package winning.quadruplets;

import game.Board;
import winning.PlayerLiveStonesBoard;
import winning.indexes.VerticalIndexes;
import winning.limits.VerticalLimits;
import winning.rules.VerticalRules;

public class VerticalQuadruplets implements Quadruplets {
    
    private VerticalLimits verticalLimits;
    private VerticalRules verticalRules;
    private Board fullBoard;

    public VerticalQuadruplets(Board fullBoard) {
        this.verticalLimits = new VerticalLimits(fullBoard.size());
        this.verticalRules = new VerticalRules(verticalLimits.beginRow(), verticalLimits.endRowInclusive());
        this.fullBoard = fullBoard;
    }

    public void findQuadruplets(Character currentStone, PlayerLiveStonesBoard liveStonesBoard) {
        
        int beginRow = verticalLimits.beginRow();
        int beginCol = verticalLimits.beginCol();
        int endRow = verticalLimits.endRowInclusive();
        int endCol = verticalLimits.endColInclusive();
        
        for(int col=beginCol; col<=endCol; col++) {
            for(int row=beginRow; row<=endRow; row++) {

                if(verticalRules.isValid(fullBoard, row, col, currentStone) 
                        && verticalRules.isCandidate(fullBoard, row, col)) {
                   VerticalIndexes verticalIndexes = new VerticalIndexes(row, col);
                   verticalIndexes.setIndexes(liveStonesBoard);
                }
            }
        }
    }
    
}
