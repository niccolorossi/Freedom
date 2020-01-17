package game.freedom;

import game.Board;

public class NextMoveFreedom {
    
    private Boolean isMoveFreedom;
    
    public NextMoveFreedom(Board board, Integer row, Integer column) {
        CloseCellsValues closeCellsValues = new CloseCellsValues(board, row, column);
        isMoveFreedom = !closeCellsValues.getCloseValues().stream().anyMatch(x -> x == board.emptyCellCharacter());
    }

    public Boolean isNextFreedom() {
        return isMoveFreedom;
    }
}
