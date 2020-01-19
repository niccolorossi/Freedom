package game;

import exceptions.NonAdjacentException;
import exceptions.OccupiedCellException;
import game.freedom.NextMoveFreedom;
import winning.Winner;

public class GameStatus {
    
    private Board board;
    private BoardAsString boardAsString;
    private Boolean isFreedom;
    private Integer previousRow;
    private Integer previousColumn;
    private Character newStone;
    private Boolean isLastMove;
    
    public GameStatus(int size) {
        this.board = new Board(size);
        this.newStone = 'W';
        this.isFreedom = true;
        this.boardAsString = new BoardAsString();
        this.isLastMove = false;
    }

    @Override
    public String toString() {
        return boardAsString.parsedBoard(board);
    }
    
    public void updateStatus(Integer row, Integer column) 
    throws NonAdjacentException, OccupiedCellException {
        Move move;
        if(isFreedom) {
            move = new FreedomMove(row, column, newStone);
        } else if(isLastMove) {
            move = new LastMove(newStone);
        } else {
            move = new RegularMove(row, column, previousRow, previousColumn,
                                    newStone, board);
        }
        move.setMove(board);
        
        changeStone();
        
        updateMoveFreedom(row, column);
        
        updatePreviousCoordinates(row, column);
    }
    
    public void updateMoveFreedom(Integer row, Integer column) {
        NextMoveFreedom nextMoveFreedom = new NextMoveFreedom(board, row, column);
        this.isFreedom = nextMoveFreedom.isNextFreedom();
    }
    
    public void updatePreviousCoordinates(Integer row, Integer column) {
        this.previousRow = row;
        this.previousColumn = column;
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
    
    public void lastMove() {
        this.isLastMove = true;
        this.isFreedom = false;
        Move move = new LastMove(newStone);
        move.setMove(board);
    }

    public String winner() {
        return new Winner(board.currentBoard()).getWinner();
    }
}
