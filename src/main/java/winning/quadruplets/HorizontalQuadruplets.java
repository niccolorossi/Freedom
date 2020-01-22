package winning.quadruplets;

import game.Board;
import winning.LiveStonesBoard;
import winning.indexes.HorizontalIndexes;
import winning.limits.HorizontalLimits;
import winning.rules.HorizontalRules;

public class HorizontalQuadruplets implements Quadruplets {

    private HorizontalLimits horizontalLimits;
    private HorizontalRules horizontalRules;
    
    public HorizontalQuadruplets(Board fullBoard) {
        this.horizontalLimits = new HorizontalLimits(fullBoard.size());
        this.horizontalRules = new HorizontalRules(horizontalLimits.beginCol(), horizontalLimits.endColInclusive());
    }

    public void findQuadruplets(Board fullBoard, Character currentStone, LiveStonesBoard liveStonesBoard) {

        int beginRow = horizontalLimits.beginRow();
        int beginCol = horizontalLimits.beginCol();
        int endRow = horizontalLimits.endRowInclusive();
        int endCol = horizontalLimits.endColInclusive();
        
        for(int row=beginRow; row<=endRow; row++) {
            for(int col=beginCol; col<=endCol; col++) {

                if(horizontalRules.isValid(fullBoard, row, col, currentStone)
                        && horizontalRules.isCandidate(fullBoard, row, col)) {
                    HorizontalIndexes indexes = new HorizontalIndexes(row, col);
                    indexes.setIndexes(liveStonesBoard);
                }
            }
        }
    }
    
}

