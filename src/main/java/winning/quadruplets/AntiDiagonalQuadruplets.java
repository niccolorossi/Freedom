package winning.quadruplets;

import game.Board;
import winning.indexes.AntiDiagonalIndexes;
import winning.indexes.Indexes;
import winning.limits.AntiDiagonalLimits;
import winning.rules.AntiDiagonalRules;

import java.util.ArrayList;
import java.util.List;

public class AntiDiagonalQuadruplets implements Quadruplets {

    private AntiDiagonalLimits antiDiagonalLimits;
    private AntiDiagonalRules antiDiagonalRules;
    private Board fullBoard;

    public AntiDiagonalQuadruplets(Board fullBoard) {
        this.antiDiagonalLimits = new AntiDiagonalLimits(fullBoard.size());
        this.antiDiagonalRules = new AntiDiagonalRules(antiDiagonalLimits.beginRow(),
                                                       antiDiagonalLimits.beginCol(),
                                                       antiDiagonalLimits.endRowInclusive(),
                                                       antiDiagonalLimits.endColInclusive());
        this.fullBoard = fullBoard;
    }

    @Override
    public List<Indexes> getQuadruplets(Character currentStone) {
        
        int beginRow = antiDiagonalLimits.beginRow();
        int beginCol = antiDiagonalLimits.beginCol();
        int endRow = antiDiagonalLimits.endRowInclusive();
        int endCol = antiDiagonalLimits.endColInclusive();
        
        List<Indexes> toReturn = new ArrayList<>();
        
        for(int row=beginRow; row>=endRow; row--) {
            for(int col=beginCol; col<=endCol; col++) {

                if(antiDiagonalRules.isValid(fullBoard, row, col, currentStone)
                        && antiDiagonalRules.isCandidate(fullBoard, row, col)) {
                    toReturn.add(new AntiDiagonalIndexes(row, col));
                }
            }
        }
        return toReturn;
    }
    
}
