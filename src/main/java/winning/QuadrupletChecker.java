package winning;

import winning.quadruplet.AntiDiagonalQuadruplet;
import winning.quadruplet.DiagonalQuadruplet;
import winning.quadruplet.HorizontalQuadruplet;
import winning.quadruplet.VerticalQuadruplet;
import winning.rules.AntiDiagonalRules;
import winning.rules.DiagonalRules;
import winning.rules.HorizontalRules;
import winning.rules.VerticalRules;

public class QuadrupletChecker {
    
    private LiveStonesBoard liveStonesBoard;
    private Character[][] fullBoard;
    private Integer boardSize;
    
    private Character currentStone;
    
    private Integer beginColOfLeftmostHorizontalQuadruplets ;
    private Integer beginColOfRightmostHorizontalQuadruplets;

    private Integer beginRowOfUppermostVerticalQuadruplets;
    private Integer beginRowOfLowermostVerticalQuadruplets;
    
    private Integer beginRowOfUppermostDiagonalQuadruplets;
    private Integer beginColOfUppermostDiagonalQuadruplets;
    private Integer beginRowOfLowermostDiagonalQuadruplets;
    private Integer beginColOfLowermostDiagonalQuadruplets;

    private Integer beginRowOfLowermostAntiDiagonalQuadruplets;
    private Integer beginColOfLowermostAntiDiagonalQuadruplets;
    private Integer beginRowOfUppermostAntiDiagonalQuadruplets;
    private Integer beginColOfUppermostAntiDiagonalQuadruplets;


    public QuadrupletChecker(LiveStonesBoard liveStonesBoard, Character[][] fullBoard, Character currentStone) {

        this.liveStonesBoard = liveStonesBoard;
        this.fullBoard = fullBoard;
        this.boardSize = liveStonesBoard.getCurrentBoard().length;
        this.currentStone = currentStone;

        this.beginColOfLeftmostHorizontalQuadruplets
                = this.beginRowOfUppermostDiagonalQuadruplets
                = this.beginRowOfUppermostVerticalQuadruplets
                = this.beginColOfUppermostDiagonalQuadruplets
                = this.beginColOfLowermostAntiDiagonalQuadruplets = 0;

        this.beginColOfRightmostHorizontalQuadruplets
                = this.beginRowOfLowermostVerticalQuadruplets
                = this.beginRowOfLowermostDiagonalQuadruplets
                = this.beginColOfLowermostDiagonalQuadruplets
                = this.beginColOfUppermostAntiDiagonalQuadruplets = fullBoard[0].length - 4;

        this.beginRowOfLowermostAntiDiagonalQuadruplets = fullBoard[0].length - 1;
        this.beginRowOfUppermostAntiDiagonalQuadruplets = 3;



    }



    public void setAllRowStones() {
        HorizontalRules horizontalRules = new HorizontalRules(beginColOfLeftmostHorizontalQuadruplets,
                                                              beginColOfRightmostHorizontalQuadruplets);

        for(int row=0; row<boardSize; row++) {

            for(int col=beginColOfLeftmostHorizontalQuadruplets; col<=beginColOfRightmostHorizontalQuadruplets; col++) {

                if(horizontalRules.isValid(fullBoard, row, col, currentStone)
                   && horizontalRules.isCandidate(fullBoard, row, col)) {

                    liveStonesBoard.setStones(new HorizontalQuadruplet(row,col));
                }
            }
      
        }
    }
    
    public void setAllColumnStones() {
        VerticalRules verticalRules = new VerticalRules(beginRowOfUppermostVerticalQuadruplets,
                                                        beginRowOfLowermostVerticalQuadruplets);         
        for(int col=0; col<boardSize; col++) {
            for(int row=beginRowOfUppermostVerticalQuadruplets; row<=beginRowOfLowermostVerticalQuadruplets; row++) {

                if(verticalRules.isValid(fullBoard, row, col, currentStone) && verticalRules.isCandidate(fullBoard, row, col)) {
                    liveStonesBoard.setStones(new VerticalQuadruplet(row,col));
                }
            }

        }
    }

    public void setAllDiagonalStones() {

        DiagonalRules diagonalRules = new DiagonalRules(beginRowOfUppermostDiagonalQuadruplets,
                                                        beginColOfUppermostDiagonalQuadruplets,
                                                        beginRowOfLowermostDiagonalQuadruplets,
                                                        beginColOfLowermostDiagonalQuadruplets);

        for(int row=beginRowOfUppermostDiagonalQuadruplets; row<=beginRowOfLowermostDiagonalQuadruplets; row++) {
            for(int col=beginColOfUppermostDiagonalQuadruplets; col<=beginColOfLowermostDiagonalQuadruplets; col++) {

                if(diagonalRules.isValid(fullBoard, row, col, currentStone) && diagonalRules.isCandidate(fullBoard, row, col)) {
                    liveStonesBoard.setStones(new DiagonalQuadruplet(row,col));
                }
            }
        }
    }

    public void setAllAntiDiagonalStones() {
        AntiDiagonalRules antiDiagonalRules = new AntiDiagonalRules(beginRowOfLowermostAntiDiagonalQuadruplets,
                                                                    beginColOfLowermostAntiDiagonalQuadruplets,
                                                                    beginRowOfUppermostAntiDiagonalQuadruplets,
                                                                    beginColOfUppermostAntiDiagonalQuadruplets);

        for(int row = beginRowOfLowermostAntiDiagonalQuadruplets; row>= beginRowOfUppermostAntiDiagonalQuadruplets; row--) {

            for(int col = beginColOfLowermostAntiDiagonalQuadruplets; col<= beginColOfUppermostAntiDiagonalQuadruplets; col++) {

                if(antiDiagonalRules.isValid(fullBoard, row, col, currentStone)
                        && antiDiagonalRules.isCandidate(fullBoard, row, col)) {
                    liveStonesBoard.setStones(new AntiDiagonalQuadruplet(row,col));
                }
            }
        }
    }
}
