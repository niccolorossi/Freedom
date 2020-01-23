package winning;

import game.Board;

public class Points {
    
    private PlayerQuadruplets playerQuadruplets;

    public Points(Board fullBoard, Character playerCharacter) {
        
        this.playerQuadruplets = new PlayerQuadruplets(fullBoard, playerCharacter);
    }

    public Integer getScore() {
        
        playerQuadruplets.findAllQuadruplets();
        LiveStonesBoard playerLiveStonesBoard = playerQuadruplets.getPlayerLiveStonesBoard();
        
        int boardSize = playerLiveStonesBoard.size();
        int count = 0;

        for(int row = 0; row < boardSize; row ++){
            for (int col = 0; col < boardSize; col ++){
                count += playerLiveStonesBoard.getLiveStone(row, col) ? 1 : 0;
            }
        }
        return count;
    }    
}
    
    //responsabilità: contare i punti

