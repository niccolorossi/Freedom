package game.freedom;

import game.Board;

public class FreedomMove {
    
    private Boolean isMoveFreedom;
    
    public FreedomMove(Board board, Integer row, Integer column) {
        CloseCells closeCells = new CloseCells(board, row, column);
        isMoveFreedom = !closeCells.getCloseValues().stream().anyMatch(x -> x == board.getEmptyCellCharacter());
    }

    public Boolean isNextFreedom() {
        return isMoveFreedom;
    }
}
