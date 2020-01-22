package winning;

import game.Board;

import java.util.stream.IntStream;

public class LiveStonesBoard {
    
    private Boolean[][] currentBoard;

    public LiveStonesBoard(Board fullBoard) {

        Integer boardSize = fullBoard.size();

        this.currentBoard = new Boolean[boardSize][boardSize];
        IntStream.range(0, boardSize)
                .forEach(r -> IntStream.range(0, boardSize)
                        .forEach(c -> currentBoard[r][c] = false));
    }

    public Boolean[][] getCurrentBoard() {
        return currentBoard;
    }
    
    public void placeLiveStones(int row, int column) {
        currentBoard[row][column] = true;
    }

    public int size() {
        return currentBoard[0].length;
    }
}
