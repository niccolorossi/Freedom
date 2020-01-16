package winning;

import winning.indeces.AntiDiagonalIndeces;
import winning.indeces.DiagonalIndeces;
import winning.indeces.HorizontalIndeces;
import winning.indeces.VerticalIndeces;
import winning.limits.AntiDiagonalLimits;
import winning.limits.DiagonalLimits;
import winning.limits.HorizontalLimits;
import winning.limits.VerticalLimits;
import winning.quadruplets.DiagonalQuadruplets;
import winning.quadruplets.HorizontalQuadruplets;
import winning.quadruplets.VerticalQuadruplets;
import winning.rules.AntiDiagonalRules;

import java.util.List;

public class PlayerQuadruplets {
    
    private LiveStonesBoard liveStonesBoard;
    private Character[][] fullBoard;
    private Character currentStone;

    private HorizontalQuadruplets horizontalQuadruplets;
    private VerticalQuadruplets verticalQuadruplets;
    private DiagonalQuadruplets diagonalQuadruplets;


    private HorizontalLimits horizontalLimits;
    private VerticalLimits verticalLimits;
    private DiagonalLimits diagonalLimits;
    private AntiDiagonalLimits antiDiagonalLimits;
    



    public PlayerQuadruplets(LiveStonesBoard liveStonesBoard, Character[][] fullBoard, Character currentStone) {

        this.liveStonesBoard = liveStonesBoard;
        this.fullBoard = fullBoard;
        this.currentStone = currentStone;
        this.horizontalQuadruplets = new HorizontalQuadruplets(fullBoard);
        this.verticalQuadruplets = new VerticalQuadruplets(fullBoard);
        this.diagonalQuadruplets = new DiagonalQuadruplets(fullBoard);

        this.verticalLimits = new VerticalLimits(fullBoard[0].length);
        this.diagonalLimits = new DiagonalLimits(fullBoard[0].length);
        this.antiDiagonalLimits = new AntiDiagonalLimits(fullBoard[0].length);





    }



    public void findHorizontalQuadruplets() {

        List<HorizontalIndeces> allHorizontal = horizontalQuadruplets.findQuadruplets(fullBoard, currentStone);

        for(int quadruplet = 0; quadruplet < allHorizontal.size(); quadruplet ++) {
            liveStonesBoard.updateLiveStones(allHorizontal.get(quadruplet));
        }


    }
    
    public void findVerticalQuadruplets() {

        List<VerticalIndeces> allVertical = verticalQuadruplets.findQuadruplets(fullBoard, currentStone);

        for(int quadruplet = 0; quadruplet < allVertical.size(); quadruplet ++) {
            liveStonesBoard.updateLiveStones(allVertical.get(quadruplet));
        }
    }

    public void findDiagonalQuadruplets() {
        List<DiagonalIndeces> allDiagonal = diagonalQuadruplets.findQuadruplets(fullBoard, currentStone);

        for(int quadruplet = 0; quadruplet < allDiagonal.size(); quadruplet ++) {
            liveStonesBoard.updateLiveStones(allDiagonal.get(quadruplet));
        }

    }

    public void findAntiDiagonalQuadruplets() {

        Integer beginRowOfLowermostAntiDiagonalQuadruplets = antiDiagonalLimits.beginRowOfLowermostAntiDiagonalQuadruplets();
        Integer beginColOfLowermostAntiDiagonalQuadruplets = antiDiagonalLimits.beginColOfLowermostAntiDiagonalQuadruplets();
        Integer beginRowOfUppermostAntiDiagonalQuadruplets = antiDiagonalLimits.beginRowOfUppermostAntiDiagonalQuadruplets();
        Integer beginColOfUppermostAntiDiagonalQuadruplets = antiDiagonalLimits.beginColOfUppermostAntiDiagonalQuadruplets();

        AntiDiagonalRules antiDiagonalRules = new AntiDiagonalRules(beginRowOfLowermostAntiDiagonalQuadruplets,
                                                                    beginColOfLowermostAntiDiagonalQuadruplets,
                                                                    beginRowOfUppermostAntiDiagonalQuadruplets,
                                                                    beginColOfUppermostAntiDiagonalQuadruplets);

        for(int row = beginRowOfLowermostAntiDiagonalQuadruplets; row>= beginRowOfUppermostAntiDiagonalQuadruplets; row--) {

            for(int col = beginColOfLowermostAntiDiagonalQuadruplets; col<= beginColOfUppermostAntiDiagonalQuadruplets; col++) {

                if(antiDiagonalRules.isValid(fullBoard, row, col, currentStone)
                        && antiDiagonalRules.isCandidate(fullBoard, row, col)) {
                    liveStonesBoard.updateLiveStones(new AntiDiagonalIndeces(row,col));
                }
            }
        }
    }
}
