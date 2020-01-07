package it.freedom;

import it.freedom.exceptions.NonAdjacentException;
import it.freedom.exceptions.OccupiedCellException;
import it.freedom.exceptions.OutOfBoundsException;

import java.util.stream.IntStream;

class Board {
    
    private Character[][] currentBoard;
    private int boardSize;
    private char emptyCellCharacter = '_';
    private Integer previousRow;
    private  Integer previousColumn;
 
    Board(int boardSize) {

        this.boardSize = boardSize;
        this.currentBoard = new Character[boardSize][boardSize];
        IntStream.range(0, boardSize)
                .forEach(r -> IntStream.range(0, boardSize)
                        .forEach(c -> currentBoard[r][c] = emptyCellCharacter));
        this.previousRow = -1;
        this.previousColumn = -1;
        
    }
    
    Character[][] getCurrentBoard() {
        return this.currentBoard;
    }
    
    void setStone(Character symbol, int row, int column) throws NonAdjacentException {
        try {
            BoundsChecker.boundsCheck(boardSize, row);
            BoundsChecker.boundsCheck(boardSize, column);
            OccupiedChecker.occupiedCheck(this, row, column);
            AdjacentChecker.adjacentCheck(previousRow, previousColumn, row, column);
            currentBoard[row-1][column-1] = symbol;
            previousRow = row;
            previousColumn = column;
            
        } catch (OutOfBoundsException | OccupiedCellException e) {
            System.out.println(e.getMessage());
        }
    }

    Character getEmptyCellCharacter() {
        return emptyCellCharacter;
    }
}
