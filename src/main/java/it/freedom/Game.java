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


    public void playerMove(int i, int i1) throws OutOfBoundsException {
        if( i < 0 || i > 9) {
            throw new OutOfBoundsException(i + " is out of bound!");
        }
    }
}
