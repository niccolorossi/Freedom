package winning.quadruplets;

import game.Board;
import winning.indexes.DiagonalIndexes;
import winning.limits.DiagonalLimits;
import winning.rules.DiagonalRules;

import java.util.ArrayList;
import java.util.List;

public class DiagonalQuadruplets {

    private DiagonalLimits diagonalLimits;
    private DiagonalRules diagonalRules;

    public DiagonalQuadruplets(Board fullBoard) {
        this.diagonalLimits = new DiagonalLimits(fullBoard.size());
        this.diagonalRules = new DiagonalRules(diagonalLimits.beginRowOfUppermostDiagonalQuadruplets(),
                                                diagonalLimits.beginRowOfUppermostDiagonalQuadruplets(),
                                                diagonalLimits.beginRowOfLowermostDiagonalQuadruplets(),
                                                diagonalLimits.beginColOfLowermostDiagonalQuadruplets());

    }

    public List<DiagonalIndexes> findQuadruplets(Board fullBoard, Character currentStone) {

        ArrayList<DiagonalIndexes> allDiagonals = new ArrayList<>();
        Integer beginRowOfUppermostDiagonalQuadruplets = diagonalLimits.beginRowOfUppermostDiagonalQuadruplets();
        Integer beginColOfUppermostDiagonalQuadruplets = diagonalLimits.beginColOfUppermostDiagonalQuadruplets();
        Integer beginRowOfLowermostDiagonalQuadruplets = diagonalLimits.beginRowOfLowermostDiagonalQuadruplets();
        Integer beginColOfLowermostDiagonalQuadruplets = diagonalLimits.beginColOfLowermostDiagonalQuadruplets();

        for(int row=beginRowOfUppermostDiagonalQuadruplets; row<=beginRowOfLowermostDiagonalQuadruplets; row++) {
            for(int col=beginColOfUppermostDiagonalQuadruplets; col<=beginColOfLowermostDiagonalQuadruplets; col++) {

                if(diagonalRules.isValid(fullBoard, row, col, currentStone) && diagonalRules.isCandidate(fullBoard, row, col)) {
                    allDiagonals.add(new DiagonalIndexes(row,col));
                }
            }
        }

        return allDiagonals;
    }
}
