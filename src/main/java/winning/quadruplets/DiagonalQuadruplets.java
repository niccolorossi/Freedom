package winning.quadruplets;

import game.Board;
import winning.LiveStonesBoard;
import winning.indexes.DiagonalIndexes;
import winning.limits.DiagonalLimits;
import winning.rules.DiagonalRules;

public class DiagonalQuadruplets implements Quadruplets {

    private DiagonalLimits diagonalLimits;
    private DiagonalRules diagonalRules;
    private Board fullBoard;

    public DiagonalQuadruplets(Board fullBoard) {
        this.diagonalLimits = new DiagonalLimits(fullBoard.size());
        this.diagonalRules = new DiagonalRules(diagonalLimits.beginRow(),
                                                diagonalLimits.beginRow(),
                                                diagonalLimits.endRowInclusive(),
                                                diagonalLimits.endColInclusive());
        this.fullBoard = fullBoard;

    }

    public void findQuadruplets(Character currentStone, LiveStonesBoard liveStonesBoard) {

        int beginRow = diagonalLimits.beginRow();
        int beginCol = diagonalLimits.beginCol();
        int endRow = diagonalLimits.endRowInclusive();
        int endCol = diagonalLimits.endColInclusive();

        for(int row=beginRow; row<=endRow; row++) {
            for(int col=beginCol; col<=endCol; col++) {

                if(diagonalRules.isValid(fullBoard, row, col, currentStone) 
                        && diagonalRules.isCandidate(fullBoard, row, col)) {
                    DiagonalIndexes indexes = new DiagonalIndexes(row, col);
                    indexes.setIndexes(liveStonesBoard);
                }
            }
        }
    }
    
}
