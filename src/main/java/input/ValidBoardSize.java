package input;

import exceptions.BoardTooSmall;

class ValidBoardSize {
    
    private Integer boardSize;
    
    ValidBoardSize(Integer boardSize) {
        this.boardSize = boardSize;
    }
    
    Integer boardSize() throws BoardTooSmall {
        if(boardSize < 6) {
            throw new BoardTooSmall("Board size must be greater or equal than 6!");
        } else return boardSize;
    }
}
