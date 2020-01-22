package game;

import game.freedom.NextMoveFreedom;
import winning.Winner;

import java.util.List;

public class GameStatus {
    
    private Board board;
    private Boolean isFreedom;
    private Character newStone;
    
    
    public GameStatus(int size) {
        this.board = new Board(size);
        this.newStone = 'W';
        this.isFreedom = true;
    }
    
    public void updateStatus(RegularMove move) {
        
        move.setMove(board);
        changeStone();
        Integer row = move.getRow();
        Integer column = move.getColumn();
        updateMoveFreedom(row, column);
    }

    public void updateStatus(LastMove move) {

        move.setMove(board);
    }
    
    public void updateMoveFreedom(Integer row, Integer column) {

        NextMoveFreedom nextMoveFreedom = new NextMoveFreedom(board, row, column);
        this.isFreedom = nextMoveFreedom.isNextFreedom();
    }
    
    private void changeStone() { newStone = (newStone == 'W') ? 'B' : 'W'; }
    
    Character currentPlayer(){
        return newStone;
    }

    public List<Integer> winner() {
        return new Winner(board).getWinner();
    }
    
    public Board getBoard(){
        return this.board;
    }
    
    public Boolean isFreedom(){
        return isFreedom;
    }
}
