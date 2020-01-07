package checkers;

import exceptions.OccupiedCellException;

public class OccupiedChecker {
    
    private Character emptyCellCharacter;
    
    public OccupiedChecker(Character emptyCellCharacter) {
        this.emptyCellCharacter = emptyCellCharacter;
    }
    
    
    public void occupiedCheck(Character currentStone) throws OccupiedCellException {
        
        if(currentStone != emptyCellCharacter) {
            String message = "Cell is already occupied!";
            throw new OccupiedCellException(message);
        }
    }
}
