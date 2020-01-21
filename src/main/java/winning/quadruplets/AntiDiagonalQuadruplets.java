package winning.quadruplets;

import game.Board;
import winning.indexes.AntiDiagonalIndexes;
import winning.limits.AntiDiagonalLimits;
import winning.rules.AntiDiagonalRules;

import java.util.ArrayList;
import java.util.List;

public class AntiDiagonalQuadruplets {

    private AntiDiagonalLimits antiDiagonalLimits;
    private AntiDiagonalRules antiDiagonalRules;

    public AntiDiagonalQuadruplets(Board fullBoard) {
        this.antiDiagonalLimits = new AntiDiagonalLimits(fullBoard.size());
        this.antiDiagonalRules = new AntiDiagonalRules(antiDiagonalLimits.beginRowOfLowermostAntiDiagonalQuadruplets(),
                                                        antiDiagonalLimits.beginColOfLowermostAntiDiagonalQuadruplets(),
                                                        antiDiagonalLimits.beginRowOfUppermostAntiDiagonalQuadruplets(),
                                                        antiDiagonalLimits.beginColOfUppermostAntiDiagonalQuadruplets());
    }

    public List<AntiDiagonalIndexes> findQuadruplets(Board fullBoard, Character currentStone) {

        ArrayList<AntiDiagonalIndexes> allAntiDiagonals = new ArrayList<>();

        Integer beginRowOfLowermostAntiDiagonalQuadruplets = antiDiagonalLimits.beginRowOfLowermostAntiDiagonalQuadruplets();
        Integer beginColOfLowermostAntiDiagonalQuadruplets = antiDiagonalLimits.beginColOfLowermostAntiDiagonalQuadruplets();
        Integer beginRowOfUppermostAntiDiagonalQuadruplets = antiDiagonalLimits.beginRowOfUppermostAntiDiagonalQuadruplets();
        Integer beginColOfUppermostAntiDiagonalQuadruplets = antiDiagonalLimits.beginColOfUppermostAntiDiagonalQuadruplets();


        for(int row = beginRowOfLowermostAntiDiagonalQuadruplets; row>= beginRowOfUppermostAntiDiagonalQuadruplets; row--) {

            for(int col = beginColOfLowermostAntiDiagonalQuadruplets; col<= beginColOfUppermostAntiDiagonalQuadruplets; col++) {

                if(antiDiagonalRules.isValid(fullBoard, row, col, currentStone)
                        && antiDiagonalRules.isCandidate(fullBoard, row, col)) {
                    allAntiDiagonals.add(new AntiDiagonalIndexes(row,col));
                }
            }
        }

        return allAntiDiagonals;
    }
}
