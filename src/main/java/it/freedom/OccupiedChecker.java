package it.freedom;

import it.freedom.exceptions.OccupiedCellException;

import java.util.Arrays;

public class OccupiedChecker {
    
    public static void occupiedCheck(Board board, Integer row, Integer column) throws OccupiedCellException {
        
        Character emptyCellCharacter = board.getEmptyCellCharacter();
        Character[][] currentBoard = board.getCurrentBoard();
        
        if(currentBoard[row-1][column-1] != emptyCellCharacter) {
            String message = "Cell " + Arrays.asList(row, column).toString() + " is already occupied!";
            throw new OccupiedCellException(message);
        }
    }
}
