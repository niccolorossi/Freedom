package winningnic;

import java.util.stream.IntStream;

public class LiveStonesBoard {
    
    private Boolean[][] currentBoard;
    private Integer boardSize;
    
    public LiveStonesBoard(Integer boardSize) {
        
        this.boardSize = boardSize;
        this.currentBoard = new Boolean[boardSize][boardSize];
        IntStream.range(0, boardSize)
                .forEach(r -> IntStream.range(0, boardSize)
                        .forEach(c -> currentBoard[r][c] = false));    
    }
    
    public void setStones(Quadruplet quadruplet) {
        quadruplet.setStones(currentBoard);
    }
    
    public Boolean[][] getCurrentBoard() {
        return currentBoard;
    }
}
