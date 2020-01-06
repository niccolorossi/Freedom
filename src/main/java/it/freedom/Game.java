package it.freedom;

public class Game {
    
    private Board board;
    private Character currentStone;

    public Game(int size) {
        this.board = new Board(size);
        this.currentStone = 'W';
    }

    @Override
    public String toString(){
        return board.printBoard();
    }

    public void move(int x, int y) {
        
        board.setStone(currentStone, x, y);
        
    }
    
    
    
}
