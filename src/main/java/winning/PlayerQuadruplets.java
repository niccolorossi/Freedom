package winning;

import game.Board;
import winning.quadruplets.AntiDiagonalQuadruplets;
import winning.quadruplets.DiagonalQuadruplets;
import winning.quadruplets.HorizontalQuadruplets;
import winning.quadruplets.VerticalQuadruplets;

class PlayerQuadruplets {
    

    private Board fullBoard;
    private Character playerCharacter;
    private LiveStonesBoard liveStonesBoard;
    
    PlayerQuadruplets(Board fullBoard, Character playerCharacter) {

        this.fullBoard = fullBoard;
        this.playerCharacter = playerCharacter;
        this.liveStonesBoard = new LiveStonesBoard(fullBoard);
    }

    private void findAllQuadruplets() {
        
        findHorizontalQuadruplets();
        findVerticalQuadruplets();
        findDiagonalQuadruplets();
        findAntiDiagonalQuadruplets();
    }

    private void findHorizontalQuadruplets() {
        
        HorizontalQuadruplets horizontalQuadruplets = new HorizontalQuadruplets(fullBoard);
        horizontalQuadruplets.findQuadruplets(fullBoard, playerCharacter, liveStonesBoard);
    }

    private void findVerticalQuadruplets() {

        VerticalQuadruplets verticalQuadruplets = new VerticalQuadruplets(fullBoard);
        verticalQuadruplets.findQuadruplets(fullBoard, playerCharacter, liveStonesBoard);
    }

    private void findDiagonalQuadruplets() {

        DiagonalQuadruplets diagonalQuadruplets = new DiagonalQuadruplets(fullBoard);
        diagonalQuadruplets.findQuadruplets(fullBoard, playerCharacter, liveStonesBoard);

    }

    private void findAntiDiagonalQuadruplets() {

        AntiDiagonalQuadruplets antiDiagonalQuadruplets = new AntiDiagonalQuadruplets(fullBoard);
        antiDiagonalQuadruplets.findQuadruplets(fullBoard, playerCharacter, liveStonesBoard);
    }

    int countLiveStones() {
        findAllQuadruplets();
        int boardSize = liveStonesBoard.size();
        
        int count = 0;
        
        for(int row = 0; row < boardSize; row ++){
            for (int col = 0; col < boardSize; col ++){
                count += liveStonesBoard.getCurrentBoard()[row][col] ? 1 : 0;
            }
        }
        return count;
    }
}
