package checkers;

import exceptions.NonAdjacentException;
import exceptions.OccupiedCellException;
import game.Board;

import java.util.List;

public class MoveValidator {

    private Integer previousRow;
    private Integer previousColumn;

    public MoveValidator(){}

    /*
     * This ctor is for testing purposes only
     */
    public MoveValidator(Integer previousRow, Integer previousColumn) {
        this.previousRow = previousRow;
        this.previousColumn = previousColumn;
    }

    public void validate(List<Integer> coordinates, Boolean isFreedom, Board board) throws NonAdjacentException, OccupiedCellException{
        
        Integer row = coordinates.get(0);
        Integer column = coordinates.get(1);

        if(!isFreedom){
            ValidateAdjacentCoordinate validateAdjacentCell = new ValidateAdjacentCoordinate(previousRow, previousColumn);
            validateAdjacentCell.coordinateAdjacent(row, column);
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
