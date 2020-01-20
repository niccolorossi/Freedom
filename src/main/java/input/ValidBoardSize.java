package input;

import exceptions.BoardTooSmallException;

class ValidBoardSize {
    
    private Integer boardSize;
    
    ValidBoardSize(Integer boardSize) {
        this.boardSize = boardSize;
    }
    
    Integer boardSize() throws BoardTooSmallException {
        if(boardSize < 6) {
            throw new BoardTooSmallException("Board size must be greater or equal than 6!");
        } else return boardSize;
    }
}
