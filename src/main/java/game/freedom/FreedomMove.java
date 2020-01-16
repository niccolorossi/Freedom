package game.freedom;

import game.Board;

public class FreedomMove {
    
    private Boolean isMoveFreedom;
    
    public FreedomMove(Board board, Integer row, Integer column) {
        CloseCellsValues closeCellsValues = new CloseCellsValues(board, row, column);
        isMoveFreedom = !closeCellsValues.getCloseValues(board).stream().anyMatch(x -> x == board.getEmptyCellCharacter());
    }

    public Boolean isNextFreedom() {
        return isMoveFreedom;
    }
}
