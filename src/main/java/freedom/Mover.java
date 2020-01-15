package freedom;

import checkers.BoundsChecker;
import checkers.MoveValidator;
import exceptions.NonAdjacentException;
import exceptions.OccupiedCellException;
import exceptions.OutOfBoundsException;

public class Mover {

    private MoveValidator moveValidator;
    private BoundsChecker boundsChecker;
    private Boolean isFreedom;

    public Mover(Board board) {
        this.boundsChecker = new BoundsChecker(board.getBoardSize());
        this.moveValidator = new MoveValidator(board.getEmptyCellCharacter());
        this.isFreedom = true;
    }

    public void move(Board board, Integer row, Integer column, Character currentStone) throws OutOfBoundsException, NonAdjacentException, OccupiedCellException {

        boundsChecker.boundsCheck(row, column);
        Character cellStone = board.getStone(row, column);
        moveValidator.validateMove(row, column,cellStone, isFreedom);
        board.setStone(currentStone, row, column);
        isFreedom = FreedomFinder.isNextFreedom(board, row, column);
    }
}
