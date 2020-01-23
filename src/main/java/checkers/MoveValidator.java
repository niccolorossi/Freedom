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

        if(!isFreedom){
            checkIfAdjacent(coordinates);
        }
        checkIfOccupied(coordinates, board);
        updatePreviousCoordinates(coordinates);
    }

    private void checkIfAdjacent(List<Integer> coordinates) throws NonAdjacentException{
        ValidateAdjacentCoordinate validateAdjacentCell = new ValidateAdjacentCoordinate(previousRow, previousColumn);
        validateAdjacentCell.coordinateAdjacent(coordinates);
    }

    private void checkIfOccupied(List<Integer> coordinates, Board board) throws OccupiedCellException{
        ValidateOccupiedCell validateOccupiedCell = new ValidateOccupiedCell(board.emptyCellCharacter());
        validateOccupiedCell.isCellOccupied(board.stone(coordinates));
    }
    
    private void updatePreviousCoordinates(List<Integer> coordinates){
        this.previousRow = coordinates.get(0);
        this.previousColumn = coordinates.get(1);
    }
}
