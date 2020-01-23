package winning.quadruplets;

import game.Board;
import winning.PlayerLiveStonesBoard;
import winning.indexes.AntiDiagonalIndexes;
import winning.limits.AntiDiagonalLimits;
import winning.rules.AntiDiagonalRules;

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

    public void findQuadruplets(Character currentStone, PlayerLiveStonesBoard liveStonesBoard) {
        
        int beginRow = antiDiagonalLimits.beginRow();
        int beginCol = antiDiagonalLimits.beginCol();
        int endRow = antiDiagonalLimits.endRowInclusive();
        int endCol = antiDiagonalLimits.endColInclusive();
        
        for(int row=beginRow; row>=endRow; row--) {
            for(int col=beginCol; col<=endCol; col++) {

                if(antiDiagonalRules.isValid(fullBoard, row, col, currentStone)
                        && antiDiagonalRules.isCandidate(fullBoard, row, col)) {
                    AntiDiagonalIndexes indexes = new AntiDiagonalIndexes(row, col);
                    indexes.setIndexes(liveStonesBoard);
                }
            }
        }
    }
}
