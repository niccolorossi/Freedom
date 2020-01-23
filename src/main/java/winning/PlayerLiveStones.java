package winning;

import game.Board;
import winning.indexes.Indexes;

import java.util.List;

class PlayerLiveStones {
    
    private PlayerIndexes playerIndexes;
    private LiveStonesBoard liveStonesBoard;
    
    PlayerLiveStones(Board fullBoard, Character playerCharacter) {
        this.playerIndexes = new PlayerIndexes(fullBoard, playerCharacter);
        Integer boardSize = fullBoard.size();
        this.liveStonesBoard = new LiveStonesBoard(boardSize);
    }
    
    private void setAllLiveStones() {
        List<Indexes> indexesList = playerIndexes.getAllIndexes();
        Integer listSize = indexesList.size();
        for(int i=0; i<listSize; i++) {
            Indexes currentIndexes = indexesList.get(i);
            currentIndexes.setIndexes(liveStonesBoard);
        }
    }
    
    LiveStonesBoard getLiveStonesBoard() {
        setAllLiveStones();
        return this.liveStonesBoard;
    }
    
}
