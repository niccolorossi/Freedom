package checkers;

import exceptions.OccupiedCellException;

public class EmptyCell {
    
    private Character emptyCellCharacter;
    
    public EmptyCell(Character emptyCellCharacter) {
        this.emptyCellCharacter = emptyCellCharacter;
    }
    
    
    public void isEmpty(Character currentStone) throws OccupiedCellException {
        
        if(currentStone != emptyCellCharacter) {
            String message = "Cell is already occupied!";
            throw new OccupiedCellException(message);
        }
    }
}
