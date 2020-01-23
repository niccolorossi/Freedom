package winning;

import game.Board;

import winning.indexes.Indexes;
import winning.quadruplets.AntiDiagonalQuadruplets;
import winning.quadruplets.DiagonalQuadruplets;
import winning.quadruplets.HorizontalQuadruplets;
import winning.quadruplets.VerticalQuadruplets;

import java.util.ArrayList;
import java.util.List;

class PlayerIndexes {
    
    private HorizontalQuadruplets horizontalQuadruplets;
    private VerticalQuadruplets verticalQuadruplets;
    private DiagonalQuadruplets diagonalQuadruplets;
    private AntiDiagonalQuadruplets antiDiagonalQuadruplets;
    private Character playerCharacter;
    
    PlayerIndexes(Board fullBoard, Character playerCharacter) {

        this.playerCharacter = playerCharacter;
        this.horizontalQuadruplets = new HorizontalQuadruplets(fullBoard);
        this.verticalQuadruplets = new VerticalQuadruplets(fullBoard);
        this.diagonalQuadruplets = new DiagonalQuadruplets(fullBoard);
        this.antiDiagonalQuadruplets = new AntiDiagonalQuadruplets(fullBoard);
    }

    List<Indexes> getAllIndexes() {
        
        List<Indexes> toReturn = new ArrayList<>();

        toReturn.addAll(horizontalQuadruplets.getQuadruplets(playerCharacter));
        toReturn.addAll(verticalQuadruplets.getQuadruplets(playerCharacter));
        toReturn.addAll(diagonalQuadruplets.getQuadruplets(playerCharacter));
        toReturn.addAll(antiDiagonalQuadruplets.getQuadruplets(playerCharacter));

        return toReturn;
    }
    
}
