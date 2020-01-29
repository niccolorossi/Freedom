package game.checkers;

import exceptions.OccupiedCellException;

class ValidateOccupiedCell {
    
    private Character emptyCellCharacter;
    
    ValidateOccupiedCell(Character emptyCellCharacter) {
        this.emptyCellCharacter = emptyCellCharacter;
    }
    
    void isCellOccupied(Character currentStone) throws OccupiedCellException {
        if(!currentStone.equals(emptyCellCharacter)) {
            String message = "Cell is already occupied!";
            throw new OccupiedCellException(message);
        }
    }
}
