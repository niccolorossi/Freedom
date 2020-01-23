package winning;

import game.Board;

import winning.quadruplets.AntiDiagonalQuadruplets;
import winning.quadruplets.DiagonalQuadruplets;
import winning.quadruplets.HorizontalQuadruplets;
import winning.quadruplets.VerticalQuadruplets;

class PlayerQuadruplets {
    
    private Character playerCharacter;
    
    private HorizontalQuadruplets horizontalQuadruplets;
    private VerticalQuadruplets verticalQuadruplets;
    private DiagonalQuadruplets diagonalQuadruplets;
    private AntiDiagonalQuadruplets antiDiagonalQuadruplets;
    
    private PlayerLiveStonesBoard playerLiveStonesBoard;
    
    PlayerQuadruplets(Board fullBoard, Character playerCharacter, PlayerLiveStonesBoard playerLiveStonesBoard) {

        this.playerCharacter = playerCharacter;
        
        this.horizontalQuadruplets = new HorizontalQuadruplets(fullBoard);
        this.verticalQuadruplets = new VerticalQuadruplets(fullBoard);
        this.diagonalQuadruplets = new DiagonalQuadruplets(fullBoard);
        this.antiDiagonalQuadruplets = new AntiDiagonalQuadruplets(fullBoard);
        
        this.playerLiveStonesBoard = playerLiveStonesBoard;
    }

    void findAllQuadruplets() {
        
        findHorizontalQuadruplets();
        findVerticalQuadruplets();
        findDiagonalQuadruplets();
        findAntiDiagonalQuadruplets();
    }

    private void findHorizontalQuadruplets() {
        
        horizontalQuadruplets.findQuadruplets(playerCharacter, playerLiveStonesBoard);
    }

    private void findVerticalQuadruplets() {

        verticalQuadruplets.findQuadruplets(playerCharacter, playerLiveStonesBoard);
    }

    private void findDiagonalQuadruplets() {

        diagonalQuadruplets.findQuadruplets(playerCharacter, playerLiveStonesBoard);
    }

    private void findAntiDiagonalQuadruplets() {

        antiDiagonalQuadruplets.findQuadruplets(playerCharacter, playerLiveStonesBoard);
    }
}
