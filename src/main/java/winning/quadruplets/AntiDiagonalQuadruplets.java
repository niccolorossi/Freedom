package winning.quadruplets;

import winning.indeces.AntiDiagonalIndeces;
import winning.limits.AntiDiagonalLimits;
import winning.rules.AntiDiagonalRules;

import java.util.ArrayList;
import java.util.List;

public class AntiDiagonalQuadruplets {

    private AntiDiagonalLimits antiDiagonalLimits;
    private AntiDiagonalRules antiDiagonalRules;

    public AntiDiagonalQuadruplets(Character[][] fullBoard) {
        this.antiDiagonalLimits = new AntiDiagonalLimits(fullBoard[0].length);
        this.antiDiagonalRules = new AntiDiagonalRules(antiDiagonalLimits.beginRowOfLowermostAntiDiagonalQuadruplets(),
                                                        antiDiagonalLimits.beginColOfLowermostAntiDiagonalQuadruplets(),
                                                        antiDiagonalLimits.beginRowOfUppermostAntiDiagonalQuadruplets(),
                                                        antiDiagonalLimits.beginColOfUppermostAntiDiagonalQuadruplets());
    }

    public List<AntiDiagonalIndeces> findQuadruplets(Character[][] fullBoard, Character currentStone) {

        ArrayList<AntiDiagonalIndeces> allAntiDiagonals = new ArrayList<>();

        Integer beginRowOfLowermostAntiDiagonalQuadruplets = antiDiagonalLimits.beginRowOfLowermostAntiDiagonalQuadruplets();
        Integer beginColOfLowermostAntiDiagonalQuadruplets = antiDiagonalLimits.beginColOfLowermostAntiDiagonalQuadruplets();
        Integer beginRowOfUppermostAntiDiagonalQuadruplets = antiDiagonalLimits.beginRowOfUppermostAntiDiagonalQuadruplets();
        Integer beginColOfUppermostAntiDiagonalQuadruplets = antiDiagonalLimits.beginColOfUppermostAntiDiagonalQuadruplets();


        for(int row = beginRowOfLowermostAntiDiagonalQuadruplets; row>= beginRowOfUppermostAntiDiagonalQuadruplets; row--) {

            for(int col = beginColOfLowermostAntiDiagonalQuadruplets; col<= beginColOfUppermostAntiDiagonalQuadruplets; col++) {

                if(antiDiagonalRules.isValid(fullBoard, row, col, currentStone)
                        && antiDiagonalRules.isCandidate(fullBoard, row, col)) {
                    allAntiDiagonals.add(new AntiDiagonalIndeces(row,col));
                }
            }
        }

        return allAntiDiagonals;
    }
}
