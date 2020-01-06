package it.freedom;

public class Game {
    
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private Player currentPlayer;

    public Game(int size) {
        this.board = new Board(size);
        this.whitePlayer = new Player('W');
        this.blackPlayer = new Player('B');
        this.currentPlayer = this.whitePlayer;
    }

    @Override
    public String toString(){
        return board.printBoard();
    }

    public void move(int x, int y) {
        currentPlayer.move(x, y);
    }
    
}
