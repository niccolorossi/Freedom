package game;

import java.util.stream.IntStream;

public class Board {
    
    private Character[][] currentBoard;
    private char emptyCellCharacter = '_';
    

    Board(int boardSize) {

        this.currentBoard = new Character[boardSize][boardSize];
        IntStream.range(0, boardSize)
                .forEach(r -> IntStream.range(0, boardSize)
                        .forEach(c -> currentBoard[r][c] = emptyCellCharacter));
    }
    
    public Character[][] getCurrentBoard() {

        return this.currentBoard;
    }
    
    public Character getStone(Integer row, Integer column) {

        return currentBoard[row-1][column-1];
    }
    
    void setStone(Character symbol, int row, int column) {

        currentBoard[row-1][column-1] = symbol;
    }

    public Character getEmptyCellCharacter() {

        return emptyCellCharacter;
    }
    
    public Integer getBoardSize() {
        return currentBoard[0].length;
    }
    
}
