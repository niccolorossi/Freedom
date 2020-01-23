package input;

import exceptions.BoardTooSmallException;

public class ValidBoardSize {
    
    private Integer boardSize;
    
    public ValidBoardSize(Integer boardSize) {
        this.boardSize = boardSize;
    }
    
    public Integer boardSize() throws BoardTooSmallException {
        if(boardSize < 6) {
            throw new BoardTooSmallException("Board size must be greater than or equal to 6!");
        } else return boardSize;
    }
}
