package checkers;

import exceptions.NonAdjacentException;
import exceptions.OccupiedCellException;

public class MoveValidator {
    private AdjacentChecker adjacentChecker;
    private OccupiedChecker occupiedChecker;
    
    public MoveValidator(Character emptyCellCharacter){
        this.adjacentChecker = new AdjacentChecker(-1,-1);
        this.occupiedChecker = new OccupiedChecker(emptyCellCharacter);
    }
    
    public void validateMove(Integer row, Integer column, Character currentStone, Boolean isFreedom) throws OccupiedCellException, NonAdjacentException{
            occupiedChecker.occupiedCheck(currentStone);
            adjacentChecker.adjacentCheck(row, column, isFreedom);


        
    }
    
}
