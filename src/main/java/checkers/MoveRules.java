package checkers;

import exceptions.NonAdjacentException;
import exceptions.OccupiedCellException;

public class MoveRules {

    private PreviousMove previousMove;
    private EmptyCell emptyCell;
    
    public MoveRules(Character emptyCellCharacter){
        this.previousMove = new PreviousMove(-1,-1);
        this.emptyCell = new EmptyCell(emptyCellCharacter);
    }
    
    public void validateMove(Integer row, Integer column, Character currentStone, Boolean isFreedom) throws OccupiedCellException, NonAdjacentException{
        emptyCell.isEmpty(currentStone);
        previousMove.isAdjacentTo(row, column, isFreedom);
            
    }
    
}
