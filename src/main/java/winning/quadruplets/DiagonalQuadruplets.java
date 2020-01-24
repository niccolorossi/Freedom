package winning.quadruplets;

import game.Board;
import winning.indexes.DiagonalIndexes;
import winning.indexes.Indexes;
import winning.limits.DiagonalLimits;
import winning.rules.DiagonalRules;

import java.util.ArrayList;
import java.util.List;

public class DiagonalQuadruplets implements Quadruplets {

    private DiagonalLimits diagonalLimits;
    private DiagonalRules diagonalRules;
    private Board fullBoard;

    public DiagonalQuadruplets(Board fullBoard) {
        this.diagonalLimits = new DiagonalLimits(fullBoard.size());
        this.diagonalRules = new DiagonalRules(diagonalLimits.beginRow(),
                                                diagonalLimits.beginCol(),
                                                diagonalLimits.endRowInclusive(),
                                                diagonalLimits.endColInclusive());
        this.fullBoard = fullBoard;

    }

    @Override
    public List<Indexes> getQuadruplets(Character currentStone) {

        int beginRow = diagonalLimits.beginRow();
        int beginCol = diagonalLimits.beginCol();
        int endRow = diagonalLimits.endRowInclusive();
        int endCol = diagonalLimits.endColInclusive();

        List<Indexes> toReturn = new ArrayList<>();

        for(int row=beginRow; row<=endRow; row++) {
            for(int col=beginCol; col<=endCol; col++) {

                if(diagonalRules.isValid(fullBoard, row, col, currentStone) 
                        && diagonalRules.isCandidate(fullBoard, row, col)) {
                    toReturn.add(new DiagonalIndexes(row, col));
                }
            }
        }
        return toReturn;
    }
    
}
