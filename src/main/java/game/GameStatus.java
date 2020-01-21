package game;

import game.freedom.NextMoveFreedom;
import output.OutputManager;
import winning.Winner;

public class GameStatus {
    
    private Board board;
    private Boolean isFreedom;
    private Character newStone;
    
    
    public GameStatus(int size) {
        this.board = new Board(size);
        this.newStone = 'W';
        this.isFreedom = true;
    }
    
    public void updateStatus(Move move) {
        
        move.setMove(board);
        changeStone();
        Integer row = move.getRow();
        Integer column = move.getColumn();
        updateMoveFreedom(row, column);
    }
    
    public void updateMoveFreedom(Integer row, Integer column) {
        NextMoveFreedom nextMoveFreedom = new NextMoveFreedom(board, row, column);
        this.isFreedom = nextMoveFreedom.isNextFreedom();

        if(isFreedom) {
            OutputManager outputManager = new OutputManager();
            outputManager.freedomMessage();
        }
    }
    
    private void changeStone(){
        if (newStone == 'W'){
            newStone = 'B';
        } else if (newStone == 'B'){
            newStone = 'W';
        }
    }
    
    Character currentPlayer(){
        return newStone;
    }

    public String winner() {
        return new Winner(board).getWinner();
    }
    
    public Board getBoard(){
        return this.board;
    }
    
    public Boolean isFreedom(){
        return isFreedom;
    }
}
