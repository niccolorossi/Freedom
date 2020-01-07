package freedom;

import checkers.AdjacentChecker;
import checkers.BoundsChecker;
import checkers.MoveValidator;
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
    private BoundsChecker boundsChecker;
    private MoveValidator moveValidator;
 
    Board(int boardSize) {

        this.boardSize = boardSize;
        this.currentBoard = new Character[boardSize][boardSize];
        IntStream.range(0, boardSize)
                .forEach(r -> IntStream.range(0, boardSize)
                        .forEach(c -> currentBoard[r][c] = emptyCellCharacter));
        
        this.boundsChecker = new BoundsChecker(boardSize);
        this.moveValidator = new MoveValidator(emptyCellCharacter);
        
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
            moveValidator.validateMove(row, column,currentStone);
            currentBoard[row-1][column-1] = symbol;
            
            
        } catch (OutOfBoundsException | NonAdjacentException | OccupiedCellException e) {
            System.out.println(e.getMessage());
        }
    }

    Character getEmptyCellCharacter() {
        return emptyCellCharacter;
    }
}
