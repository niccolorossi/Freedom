package it.freedom;

import it.checkers.AdjacentChecker;
import it.checkers.BoundsChecker;
import it.checkers.OccupiedChecker;
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
    
    private Character getStone(Integer row, Integer column) {
        return currentBoard[row-1][column-1];
    }
    
    void setStone(Character symbol, int row, int column) {
        try {
            BoundsChecker.boundsCheck(boardSize, row);
            BoundsChecker.boundsCheck(boardSize, column);
            Character currentStone = getStone(row, column);
            OccupiedChecker.occupiedCheck(currentStone, emptyCellCharacter);
            AdjacentChecker.adjacentCheck(previousRow, previousColumn, row, column);
            currentBoard[row-1][column-1] = symbol;
            previousRow = row;
            previousColumn = column;
            
        } catch (OutOfBoundsException | OccupiedCellException | NonAdjacentException e) {
            System.out.println(e.getMessage());
        }
    }

    Character getEmptyCellCharacter() {
        return emptyCellCharacter;
    }
}
