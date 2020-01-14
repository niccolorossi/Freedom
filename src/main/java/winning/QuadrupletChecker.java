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
    private AntiDiagonalRules advr;
    private Character currentStone;
    
    private Integer beginColOfLeftmostHorizontalQuadruplets = 0;
    private Integer beginColOfRightmostHorizontalQuadruplets = 6;

    private Integer beginRowOfUppermostVerticalQuadruplets = 0;
    private Integer beginRowOfLowermostVerticalQuadruplets = 6;
    
    private Integer beginRowOfUppermostDiagonalQuadruplets = 0;
    private Integer beginColOfUppermostDiagonalQuadruplets = 0;
    private Integer beginRowOfLowermostDiagonalQuadruplets = 6;
    private Integer beginColOfLowermostDiagonalQuadruplets = 6;


    public QuadrupletChecker(LiveStonesBoard liveStonesBoard, Character[][] fullBoard, Character currentStone) {
        this.liveStonesBoard = liveStonesBoard;
        this.fullBoard = fullBoard;
        this.boardSize = liveStonesBoard.getCurrentBoard().length;
        this.advr = new AntiDiagonalRules();
        this.currentStone = currentStone;
    }

    public void setAllRowStones() {
        HorizontalRules horizontalRules = new HorizontalRules(beginColOfLeftmostHorizontalQuadruplets,
                                                              beginColOfRightmostHorizontalQuadruplets);
        for(int row=0; row<boardSize; row++) {
            for(int col=beginColOfLeftmostHorizontalQuadruplets; col<=beginColOfRightmostHorizontalQuadruplets; col++) {
                HorizontalQuadruplet horizontalQuadruplet = new HorizontalQuadruplet(row,col);
                if(horizontalRules.isValid(fullBoard, row, col, currentStone) 
                   && horizontalRules.isCandidate(fullBoard, row, col)) {
                    liveStonesBoard.setStones(horizontalQuadruplet);
                }
            }
      
        }
    }
    
    public void setAllColumnStones() {
        VerticalRules verticalRules = new VerticalRules(beginRowOfUppermostVerticalQuadruplets,
                                                        beginRowOfLowermostVerticalQuadruplets);         
        for(int col=0; col<boardSize; col++) {
            for(int row=beginRowOfUppermostVerticalQuadruplets; row<=beginRowOfLowermostVerticalQuadruplets; row++) {
                VerticalQuadruplet verticalQuadruplet = new VerticalQuadruplet(row,col);
                if(verticalRules.isValid(fullBoard, row, col, currentStone) && verticalRules.isCandidate(fullBoard, row, col)) {
                    liveStonesBoard.setStones(verticalQuadruplet);
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
                DiagonalQuadruplet diagonalQuadruplet = new DiagonalQuadruplet(row,col);
                if(diagonalRules.isValid(fullBoard, row, col, currentStone) && diagonalRules.isCandidate(fullBoard, row, col)) {
                    liveStonesBoard.setStones(diagonalQuadruplet);
                }
            }
        }
    }

    public void setAllAntiDiagonalStones() {
        for(int row=9; row>=3; row--) {
            for(int col=0; col<=6; col++) {
                AntiDiagonalQuadruplet antiDiagonalQuadruplet = new AntiDiagonalQuadruplet(row,col);
                if(advr.isValid(fullBoard, row, col, currentStone) && advr.isCandidate(fullBoard, row, col)) {
                    liveStonesBoard.setStones(antiDiagonalQuadruplet);
                }
            }

        }
    }
}
