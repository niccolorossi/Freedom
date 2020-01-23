package game.freedom;

import game.Board;

public class NextMoveFreedom {
    
    private Boolean isMoveFreedom;

    public NextMoveFreedom(Board board, Integer row, Integer column) {
        this.isMoveFreedom = verifyFreedom(board, row, column);
    }

    public Boolean isNextFreedom() {
        return isMoveFreedom;
    }

    private Boolean verifyFreedom(Board board, Integer row, Integer column) {
        CloseCellsValues closeCellsValues = new CloseCellsValues(board, row, column);
        return !closeCellsValues.getCloseValues().stream().anyMatch(x -> x == board.emptyCellCharacter());
    }
}
