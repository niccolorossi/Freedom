package game.freedom;

import game.Board;
import game.Move;

public class NextMoveFreedom {
    
    private Boolean isMoveFreedom;

    public NextMoveFreedom(Board board, Move move) {
        this.isMoveFreedom = verifyFreedom(board,move);
    }

    public Boolean isNextFreedom() {
        return isMoveFreedom;
    }

    private Boolean verifyFreedom(Board board, Move move) {
        CloseCellsValues closeCellsValues = new CloseCellsValues(board, move.getRow(), move.getColumn());
        return !closeCellsValues.getCloseValues().stream().anyMatch(x -> x == board.emptyCellCharacter());
    }
}
