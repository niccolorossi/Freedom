package winning.quadruplets;

import game.Board;
import winning.LiveStonesBoard;
import winning.indexes.HorizontalIndexes;
import winning.indexes.Indexes;
import winning.limits.HorizontalLimits;
import winning.rules.HorizontalRules;

import java.util.ArrayList;
import java.util.List;

public class HorizontalQuadruplets implements Quadruplets {

    private HorizontalLimits horizontalLimits;
    private HorizontalRules horizontalRules;
    private Board fullBoard;
    
    public HorizontalQuadruplets(Board fullBoard) {
        this.horizontalLimits = new HorizontalLimits(fullBoard.size());
        this.horizontalRules = new HorizontalRules(horizontalLimits.beginCol(), horizontalLimits.endColInclusive());
        this.fullBoard = fullBoard;
    }

    @Override
    public List<Indexes> getQuadruplets(Character currentStone) {

        int beginRow = horizontalLimits.beginRow();
        int beginCol = horizontalLimits.beginCol();
        int endRow = horizontalLimits.endRowInclusive();
        int endCol = horizontalLimits.endColInclusive();

        List<Indexes> toReturn = new ArrayList<>();

        for(int row=beginRow; row<=endRow; row++) {
            for(int col=beginCol; col<=endCol; col++) {

                if(horizontalRules.isValid(fullBoard, row, col, currentStone)
                        && horizontalRules.isCandidate(fullBoard, row, col)) {
                    toReturn.add(new HorizontalIndexes(row, col));
                }
            }
        }
        return toReturn;
    }
    
}

