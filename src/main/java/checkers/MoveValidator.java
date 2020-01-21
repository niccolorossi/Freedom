package checkers;

import exceptions.NonAdjacentException;
import exceptions.OccupiedCellException;
import game.Board;

import java.util.List;

public class MoveValidator {
    
    private Integer previousRow;
    private Integer previousColumn;
    
    public void validate(List<Integer> coordinates, Boolean isFreedom, Board board) throws NonAdjacentException, OccupiedCellException{
        
        Integer row = coordinates.get(0);
        Integer column = coordinates.get(1);
        
        ValidateAdjacentCoordinate validateAdjacentRow = new ValidateAdjacentCoordinate(previousRow);
        ValidateAdjacentCoordinate validateAdjacentColumn = new ValidateAdjacentCoordinate(previousColumn);
        
        if(!isFreedom){
            validateAdjacentRow.isCoordinateAdjacent(row);
            validateAdjacentColumn.isCoordinateAdjacent(column);
        }
        
        ValidateOccupiedCell validateOccupiedCell = new ValidateOccupiedCell(board.emptyCellCharacter());
        validateOccupiedCell.isCellOccupied(board.stone(row,column));
        
        updatePreviousCoordinates(row, column);
    }
    
    private void updatePreviousCoordinates(Integer row, Integer column){
        this.previousRow = row;
        this.previousColumn = column;
    }
    
    
}
