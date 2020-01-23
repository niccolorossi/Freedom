package winning;

import game.Board;

public class Points {
    
    private PlayerLiveStonesBoard playerLiveStonesBoard;

    public Points(Board fullBoard, Character playerCharacter) {

        this.playerLiveStonesBoard = new PlayerLiveStonesBoard(fullBoard, playerCharacter);
    }

    public Integer getScore() {
        
        playerLiveStonesBoard.setAllPlayerLiveStones();
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

