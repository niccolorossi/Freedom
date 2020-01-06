package it.freedom;

public class Game {
    
    private Board board;

    public Game(int size) {
        this.board = new Board(size);
    }

    @Override
    public String toString(){
        return board.printBoard();
    }


}
