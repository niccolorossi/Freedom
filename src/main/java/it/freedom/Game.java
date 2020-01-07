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
        return BoardPrinter.boardPrinter(board);
    }

    public void move(Integer row, Integer column) {
        board.setStone(currentStone, row, column);
        currentStone = nextPlayer();
    }
    
    private Character nextPlayer() {
        if(currentStone == 'B') {
           return 'W'; 
        } else return 'B';
    }
    
    public Character getCurrentStone() {
        return this.currentStone;
    }
}
