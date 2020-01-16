package game;

import game.freedom.FreedomMove;
import input.MoveInBoundsValidator;
import checkers.MoveValidator;
import exceptions.NonAdjacentException;
import exceptions.OccupiedCellException;

public class Mover {

    private MoveValidator moveValidator;
    private MoveInBoundsValidator boundsChecker;
    private Boolean isFreedom;

    public Mover(Board board) {
        //this.boundsChecker = new MoveInBoundsValidator(board.getBoardSize());
        this.moveValidator = new MoveValidator(board.getEmptyCellCharacter());
        this.isFreedom = true;
        
    }

    public void move(Board board, Integer row, Integer column, Character currentStone) throws  NonAdjacentException, OccupiedCellException {
        Character cellStone = board.getStone(row, column);
        moveValidator.validateMove(row, column,cellStone, isFreedom);
        board.setStone(currentStone, row, column);
        FreedomMove freedomFinder = new FreedomMove(board,row,column);
        isFreedom = freedomFinder.isNextFreedom();
    }
}
