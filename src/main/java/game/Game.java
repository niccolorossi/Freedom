package game;

import exceptions.NonAdjacentException;
import exceptions.OccupiedCellException;

public class Game {
    
    private Board board;
    private Character currentStone;
    private Mover mover;
    private Integer moveCounter;
    private Integer maxNumberOfMoves;
    
    public Game(int size) {
        this.board = new Board(size);
        this.currentStone = 'W';
        this.mover = new Mover(board);
        this.moveCounter = 0;
        this.maxNumberOfMoves = size*size;
    }

    @Override
    public String toString(){
        return BoardPrinter.boardPrinter(board);
    }

    public void move(Integer row, Integer column) {
        try {

            mover.move(board, row, column, currentStone);
            moveCounter ++;
            currentStone = nextPlayer();

        }catch ( NonAdjacentException | OccupiedCellException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private Character nextPlayer() {
        if(currentStone == 'B') {
           return 'W'; 
        } else return 'B';
    }
    
    public Character getCurrentStone() {
        return this.currentStone;
    }

    public Board getBoard(){
        return board;
    }
    
    public Integer getMoveCounter() {return moveCounter;}
    
    public Integer getMaxNumberOfMoves() {return maxNumberOfMoves;}
}
