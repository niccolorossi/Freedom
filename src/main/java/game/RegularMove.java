package game;

import checkers.ValidateAdjacentCoordinate;
import checkers.ValidateOccupiedCell;
import exceptions.NonAdjacentException;
import exceptions.OccupiedCellException;

public class RegularMove extends Move {
    
    public RegularMove(Integer row, Integer column,
                       Integer previousRow, Integer previousColumn,
                       Character newStone, Character emptyCellCharacter, Character currentStone) 
    throws OccupiedCellException, NonAdjacentException {
        
        this.newStone = newStone;
        ValidateOccupiedCell validateOccupiedCell = new ValidateOccupiedCell(emptyCellCharacter);
        validateOccupiedCell.isCellOccupied(currentStone);
        ValidateAdjacentCoordinate validateRow = new ValidateAdjacentCoordinate(row);
        validateRow.validate(previousRow);
        this.row = row;
        ValidateAdjacentCoordinate validateColumn = new ValidateAdjacentCoordinate(column);
        validateColumn.validate(previousColumn);
        this.column = column;
    }
    
    
}
