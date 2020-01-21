package winning.quadruplets;

import game.Board;
import winning.indexes.VerticalIndexes;
import winning.limits.VerticalLimits;
import winning.rules.VerticalRules;

import java.util.ArrayList;
import java.util.List;

public class VerticalQuadruplets implements Quadruplets{
    private VerticalLimits verticalLimits;
    private VerticalRules verticalRules;

    public VerticalQuadruplets(Board fullBoard) {
        this.verticalLimits = new VerticalLimits(fullBoard.size());
        this.verticalRules = new VerticalRules(verticalLimits.beginRowOfUppermostVerticalQuadruplets(),
                                                verticalLimits.beginRowOfLowermostVerticalQuadruplets());

    }

    public List<VerticalIndexes> findQuadruplets(Board fullBoard, Character currentStone) {

        Integer boardSize = fullBoard.size();
        ArrayList<VerticalIndexes> verticalQuadruplets = new ArrayList<>();

        Integer beginRowOfUppermostVerticalQuadruplets = verticalLimits.beginRowOfUppermostVerticalQuadruplets();
        Integer beginRowOfLowermostVerticalQuadruplets = verticalLimits.beginRowOfLowermostVerticalQuadruplets();
        VerticalRules verticalRules = new VerticalRules(beginRowOfUppermostVerticalQuadruplets,
                beginRowOfLowermostVerticalQuadruplets);
        for(int col=0; col<boardSize; col++) {
            for(int row=beginRowOfUppermostVerticalQuadruplets; row<=beginRowOfLowermostVerticalQuadruplets; row++) {

                if(verticalRules.isValid(fullBoard, row, col, currentStone) && verticalRules.isCandidate(fullBoard, row, col)) {
                   verticalQuadruplets.add(new VerticalIndexes(row,col));
                }
            }

        }

        return verticalQuadruplets;
    }
}
