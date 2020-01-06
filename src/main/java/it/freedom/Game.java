package it.freedom;

import it.freedom.exceptions.OutOfBoundsException;

public class Game {
    
    private Board board;

    public Game(int size) {
        this.board = new Board(size);
    }

    @Override
    public String toString(){
        return board.printBoard();
    }
    
    private void checkBounds(int coordinate) throws OutOfBoundsException{
        if(coordinate < 0 || coordinate > 9)
            throw new OutOfBoundsException(coordinate + " is out of bound!");
    }

    public void playerMove(int x, int y) throws OutOfBoundsException {
        checkBounds(x);
        checkBounds(y);
        
        
    }
}
