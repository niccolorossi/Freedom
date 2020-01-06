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


    public void playerMove(int x, int y) throws OutOfBoundsException {
        if( x < 0 || x > 9) {
            throw new OutOfBoundsException(x + " is out of bound!");
        }

        if( y < 0 || y > 9) {
            throw new OutOfBoundsException(y + " is out of bound!");
        }
        
        
    }
}
