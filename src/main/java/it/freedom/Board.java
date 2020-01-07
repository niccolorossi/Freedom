package it.freedom;

import it.freedom.exceptions.OccupiedCellException;
import it.freedom.exceptions.OutOfBoundsException;

import java.util.stream.IntStream;

class Board {
    
    private Character[][] currentBoard;
    private int boardSize;
    private char emptyCellCharacter = '_';

    Board(int boardSize) {

        this.boardSize = boardSize;
        this.currentBoard = new Character[boardSize][boardSize];
        IntStream.range(0, boardSize)
                .forEach(r -> IntStream.range(0, boardSize)
                        .forEach(c -> currentBoard[r][c] = emptyCellCharacter));
    }
    
    Character[][] getCurrentBoard() {
        return this.currentBoard;
    }
    
    void setStone(Character symbol, int row, int column) {
        try {
            BoundsChecker.boundsChecker(boardSize, row);
            BoundsChecker.boundsChecker(boardSize, column);
            OccupiedChecker.occupiedChecker(this, row, column);
            currentBoard[row-1][column-1] = symbol;
        } catch (OutOfBoundsException | OccupiedCellException e) {
            System.out.println(e.getMessage());
        }
    }

    public Character getEmptyCellCharacter() {
        return emptyCellCharacter;
    }
}
