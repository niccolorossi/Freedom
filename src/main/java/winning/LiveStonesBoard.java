package winning;

import java.util.stream.IntStream;

public class LiveStonesBoard {
    
    private Boolean[][] currentBoard;

    public LiveStonesBoard(Integer boardSize) {
        
        this.currentBoard = new Boolean[boardSize][boardSize];
        IntStream.range(0, boardSize)
                .forEach(r -> IntStream.range(0, boardSize)
                        .forEach(c -> currentBoard[r][c] = false));

    }
    
    Boolean getLiveStone(int row, int column) {
        return currentBoard[row][column];
    }
    
    public void setLiveStone(int row, int column) { currentBoard[row][column] = true;}

    public int size() {
        return currentBoard[0].length;
    }
    
}
