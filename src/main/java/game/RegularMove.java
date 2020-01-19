package game;

import checkers.ValidateAdjacentCoordinate;
import checkers.ValidateOccupiedCell;
import exceptions.NonAdjacentException;
import exceptions.OccupiedCellException;

public class RegularMove extends Move {
    
    public RegularMove(Integer row, Integer column,
                       Integer previousRow, Integer previousColumn,
                       Character newStone, Board board) 
    throws OccupiedCellException, NonAdjacentException {
        
        this.newStone = newStone;
        Character emptyCellCharacter = board.emptyCellCharacter();
        Character currentStone = board.stone(row, column);
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
