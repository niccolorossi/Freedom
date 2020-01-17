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
    
    public Character[][] currentBoard() {

        return this.currentBoard;
    }
    
    public Character stone(Integer row, Integer column) {

        return currentBoard[row-1][column-1];
    }
    
    void placeStone(Character symbol, int row, int column) {

        currentBoard[row-1][column-1] = symbol;
    }

    public Character emptyCellCharacter() {

        return emptyCellCharacter;
    }
    
    public Integer size() {
        return currentBoard[0].length;
    }
    
}
