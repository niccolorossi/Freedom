package game;

import java.util.List;
import java.util.stream.IntStream;

public class Board {
    
    private Character[][] currentBoard;
    private final char emptyCellCharacter = '_';
    

    public Board (int boardSize) {

        this.currentBoard = new Character[boardSize][boardSize];
        initBoard();
    }

    private void initBoard() {
        Integer boardSize = currentBoard[0].length;
        IntStream.range(0, boardSize)
                .forEach(r -> IntStream.range(0, boardSize)
                        .forEach(c -> currentBoard[r][c] = emptyCellCharacter));
    }
    
    public Board(Character[][] characterBoard){
        this.currentBoard = characterBoard;
    }
    
    public Character[][] currentBoard() {

        return this.currentBoard;
    }
    
    public Character stone(Integer row, Integer column) {

        return currentBoard[row-1][column-1];
    }
    
    void placeStone(Character symbol, List<Integer> coordinates) {
        
        Integer row = coordinates.get(0);
        Integer column = coordinates.get(1);
        currentBoard[row-1][column-1] = symbol;
    }

    public Character emptyCellCharacter() {

        return emptyCellCharacter;
    }
    
    public Integer size() {
        return currentBoard[0].length;
    }
    
}
