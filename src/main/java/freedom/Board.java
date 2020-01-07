package freedom;

import checkers.AdjacentChecker;
import checkers.BoundsChecker;
import checkers.OccupiedChecker;
import exceptions.NonAdjacentException;
import exceptions.OccupiedCellException;
import exceptions.OutOfBoundsException;

import java.awt.event.AdjustmentEvent;
import java.util.stream.IntStream;

class Board {
    
    private Character[][] currentBoard;
    private int boardSize;
    private char emptyCellCharacter = '_';
    private AdjacentChecker adjacentChecker;
    private BoundsChecker boundsChecker;
    private OccupiedChecker occupiedChecker;
 
    Board(int boardSize) {

        this.boardSize = boardSize;
        this.currentBoard = new Character[boardSize][boardSize];
        IntStream.range(0, boardSize)
                .forEach(r -> IntStream.range(0, boardSize)
                        .forEach(c -> currentBoard[r][c] = emptyCellCharacter));
        
        this.adjacentChecker = new AdjacentChecker(-1,-1);
        this.boundsChecker = new BoundsChecker(boardSize);
        this.occupiedChecker = new OccupiedChecker(emptyCellCharacter);
        
    }
    
    Character[][] getCurrentBoard() {
        return this.currentBoard;
    }
    
    private Character getStone(Integer row, Integer column) {
        return currentBoard[row-1][column-1];
    }
    
    void setStone(Character symbol, int row, int column) {
        try {
            boundsChecker.boundsCheck(row);
            boundsChecker.boundsCheck(column);
            Character currentStone = getStone(row, column);
            occupiedChecker.occupiedCheck(currentStone);
            adjacentChecker.adjacentCheck(row, column);
            currentBoard[row-1][column-1] = symbol;
            
            
        } catch (OutOfBoundsException | OccupiedCellException | NonAdjacentException e) {
            System.out.println(e.getMessage());
        }
    }

    Character getEmptyCellCharacter() {
        return emptyCellCharacter;
    }
}
