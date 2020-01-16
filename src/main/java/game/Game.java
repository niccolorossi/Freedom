package game;

import exceptions.NonAdjacentException;
import exceptions.OccupiedCellException;
import game.freedom.NextMoveFreedom;

public class Game {
    
    private Board board;
    private BoardAsString boardAsString;
        
    private Boolean isFreedom;
    private Boolean isFirstMove;
    
    private Integer previousRow;
    private Integer previousColumn;

    public Game(int size) {
        this.board = new Board(size);
        this.isFreedom = false;
        this.isFirstMove = true;
        this.boardAsString = new BoardAsString();
    }

    @Override
    public String toString() {
        return boardAsString.parsedBoard(board);
    }
    
    public void move(Character newStone, Integer row, Integer column) 
    throws NonAdjacentException, OccupiedCellException {
        Move move;
        
        if(isFirstMove) {
            move = new FirstMove(row, column);
        } else if(isFreedom) {
            move = new FreedomMove(row, column, newStone);
        } else {
            move = new RegularMove(row, column, previousRow, previousColumn,
                                    newStone, '_', board.getStone(row, column));
        }
        move.setMove(board);
    }
    
    public void isNextMoveFreedom(Integer row, Integer column) {
        NextMoveFreedom nextMoveFreedom = new NextMoveFreedom(board, row, column);
        this.isFreedom = nextMoveFreedom.isNextFreedom();
    }
    
    public void setPreviousCoordinates(Integer row, Integer column) {
        this.previousRow = row;
        this.previousColumn = column;
    }
    
    public void setFirstMove() {
        this.isFirstMove = false;
    }

    public Board getBoard() {
        return board;
    }
}
