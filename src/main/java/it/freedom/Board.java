package it.freedom;

import it.freedom.exceptions.OutOfBoundsException;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.IntStream;

class Board {
    
    private Character[][] currentBoard;
    private int boardSize;
    private char EMPTY = '_';

    Board(int boardSize) {

        this.boardSize = boardSize;
        this.currentBoard = new Character[boardSize][boardSize];
<<<<<<< HEAD

        IntStream.range(0, boardSize)
                .forEach(r -> IntStream.range(0, boardSize)
                        .forEach(c -> currentBoard[r][c] = EMPTY));

=======
        
        IntStream.range(0, boardSize)
                .forEach(r -> IntStream.range(0, boardSize)
                        .forEach(c -> currentBoard[r][c] = emptyCellCharacter));
>>>>>>> new boardPrinter method
    }

    String printBoard() {

        StringBuilder str = new StringBuilder();

        Consumer<Character[]> pipeDelimiter = (row) -> {
            Arrays.stream(row).forEach((el) -> str.append("|" + el));
            str.append("|" +"\n"); };

        Arrays.stream(this.currentBoard)
                .forEach((row) -> pipeDelimiter.accept(row));

        return str.toString();
    }

    private void checkBounds(int coordinate) throws OutOfBoundsException {
        if(coordinate < 0 || coordinate > 9)
            throw new OutOfBoundsException(coordinate + " is out of bound!");
    }

    void setStone(Character symbol, int  x, int y) {
        try {
            
            checkBounds(x);
            checkBounds(y);
            currentBoard[x-1][y-1] = symbol;

        } catch (OutOfBoundsException e1) {
            System.out.println(e1.getMessage());
        
        } 
        
    }
}
