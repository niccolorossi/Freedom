package freedom;

import input.MoveInBoundsValidator;
import checkers.MoveValidator;
import exceptions.NonAdjacentException;
import exceptions.OccupiedCellException;
import exceptions.OutOfBoundsException;

public class Mover {

    private MoveValidator moveValidator;
    private MoveInBoundsValidator boundsChecker;
    private Boolean isFreedom;

    public Mover(Board board) {
        //this.boundsChecker = new MoveInBoundsValidator(board.getBoardSize());
        this.moveValidator = new MoveValidator(board.getEmptyCellCharacter());
        this.isFreedom = true;
    }

    public void move(Board board, Integer row, Integer column, Character currentStone) throws OutOfBoundsException, NonAdjacentException, OccupiedCellException {

      
        Character cellStone = board.getStone(row, column);
        moveValidator.validateMove(row, column,cellStone, isFreedom);
        board.setStone(currentStone, row, column);
        isFreedom = FreedomFinder.isNextFreedom(board, row, column);
    }
}
