package checkers;

import exceptions.OccupiedCellException;

public class ValidateOccupiedCell {
    
    Character emptyCellCharacter;
    
    public ValidateOccupiedCell(Character emptyCellCharacter) {
        this.emptyCellCharacter = emptyCellCharacter;
    }
    
    public void isCellOccupied(Character currentStone) throws OccupiedCellException {
        if(!currentStone.equals(emptyCellCharacter)) {
            String message = "Cell is already occupied!";
            throw new OccupiedCellException(message);
        }
    }
}
