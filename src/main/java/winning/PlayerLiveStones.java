package winning;

import game.Board;
import winning.indexes.Indexes;

import java.util.List;

public class PlayerLiveStones {
    
    private PlayerIndexes playerIndexes;
    private LiveStonesBoard liveStonesBoard;
    
    public PlayerLiveStones(Board fullBoard, Character playerCharacter) {
        this.playerIndexes = new PlayerIndexes(fullBoard, playerCharacter);
        Integer boardSize = fullBoard.size();
        this.liveStonesBoard = new LiveStonesBoard(boardSize);
    }
    
    private void setAllLiveStones() {
        List<Indexes> indexesList = playerIndexes.getAllIndexes();

        for (Indexes currentIndexes : indexesList) {
            currentIndexes.setLiveStonesForThisIndexes(liveStonesBoard);
        }
    }
    
    public LiveStonesBoard getLiveStonesBoard() {
        setAllLiveStones();
        return this.liveStonesBoard;
    }
    
}
