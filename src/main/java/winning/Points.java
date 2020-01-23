package winning;

import game.Board;

public class Points {
    
    private PlayerLiveStones playerLiveStones;

    public Points(Board fullBoard, Character playerCharacter) {
        
        this.playerLiveStones = new PlayerLiveStones(fullBoard, playerCharacter);

    }

    public Integer getScore() {
        
        LiveStonesBoard playerLiveStonesBoard = playerLiveStones.getLiveStonesBoard();
        
        int boardSize = playerLiveStonesBoard.size();
        int count = 0;

        for(int row = 0; row < boardSize; row ++) {
            for (int col = 0; col < boardSize; col ++) {
                count += playerLiveStonesBoard.getLiveStone(row, col) ? 1 : 0;
            }
        }
        return count;
    }
    
}

