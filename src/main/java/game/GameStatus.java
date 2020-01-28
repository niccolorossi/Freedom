package game;

import game.freedom.NextMoveFreedom;
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
    
    public void updateStatus(RegularMove move) {

        board.placeStone(move);
        changePlayer();
        checkIfNextMoveIsFreedom(move);
    }

    void updateStatus(LastMove move) {

        board.placeStone(move);
    }
    
    private void checkIfNextMoveIsFreedom(Move move) {

        NextMoveFreedom nextMoveFreedom = new NextMoveFreedom(board, move);
        this.isFreedom = nextMoveFreedom.isNextFreedom();
    }
    
    private void changePlayer() { newStone = (newStone == 'W') ? 'B' : 'W'; }
    
    Character currentPlayer() {
        return newStone;
    }

    String winner() {
        return new Winner(board).getWinner();
    }
    
    public Board getBoard(){
        return this.board;
    }
    
    Boolean isFreedom(){
        return isFreedom;
    }
}
