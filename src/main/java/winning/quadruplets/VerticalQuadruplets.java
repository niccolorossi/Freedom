package winning.quadruplets;

import game.Board;
import winning.indexes.Indexes;
import winning.indexes.VerticalIndexes;
import winning.limits.VerticalLimits;
import winning.rules.VerticalRules;

import java.util.ArrayList;
import java.util.List;

public class VerticalQuadruplets implements Quadruplets {
    
    private VerticalLimits verticalLimits;
    private VerticalRules verticalRules;
    private Board fullBoard;

    public VerticalQuadruplets(Board fullBoard) {
        this.verticalLimits = new VerticalLimits(fullBoard.size());
        this.verticalRules = new VerticalRules(verticalLimits.beginRow(), verticalLimits.endRowInclusive());
        this.fullBoard = fullBoard;
    }

    @Override
    public List<Indexes> getQuadruplets(Character currentStone) {
        
        int beginRow = verticalLimits.beginRow();
        int beginCol = verticalLimits.beginCol();
        int endRow = verticalLimits.endRowInclusive();
        int endCol = verticalLimits.endColInclusive();

        List<Indexes> toReturn = new ArrayList<>();

        for(int col=beginCol; col<=endCol; col++) {
            for(int row=beginRow; row<=endRow; row++) {

                if(verticalRules.isValid(fullBoard, row, col, currentStone) 
                        && verticalRules.isCandidate(fullBoard, row, col)) {
                   toReturn.add(new VerticalIndexes(row, col));
                }
            }
        }
        return toReturn;
    }
    
}
