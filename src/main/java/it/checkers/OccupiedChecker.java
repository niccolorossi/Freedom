package it.checkers;

import it.freedom.exceptions.OccupiedCellException;

public class OccupiedChecker {
    
    public static void occupiedCheck(Character currentStone, Character emptyCellCharacter) throws OccupiedCellException {
        
        if(currentStone != emptyCellCharacter) {
            String message = "Cell is already occupied!";
            throw new OccupiedCellException(message);
        }
    }
}
