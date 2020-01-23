package winning;

import game.Board;

import java.util.stream.IntStream;

public class LiveStonesBoard {
    
    private Boolean[][] currentBoard;
    
    private Character playerCharacter;
    private PlayerQuadruplets playerQuadruplets;

    public LiveStonesBoard(Board fullBoard, Character playerCharacter) {
        
        Integer boardSize = fullBoard.size();
        
        this.currentBoard = new Boolean[boardSize][boardSize];
        IntStream.range(0, boardSize)
                .forEach(r -> IntStream.range(0, boardSize)
                        .forEach(c -> currentBoard[r][c] = false));
        
        this.playerCharacter = playerCharacter;
        this.playerQuadruplets = new PlayerQuadruplets(fullBoard, playerCharacter, this);
    }
    
    public void setLiveStones(int row, int column) {
        currentBoard[row][column] = true;
    }
    
    Boolean getLiveStone(int row, int column) {
        return currentBoard[row][column];
    }

    public int size() {
        return currentBoard[0].length;
    }
    
    void setAllPlayerLiveStones() {
        playerQuadruplets.findAllQuadruplets();
    }
    
    
    
}


// responsabilità: piazzare le pietre vive
