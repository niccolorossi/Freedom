package freedom;

import exceptions.NonAdjacentException;
import exceptions.OccupiedCellException;
import exceptions.OutOfBoundsException;

public class Game {
    
    private Board board;
    private Character currentStone;
    private Mover mover;

    public Game(int size) {
        this.board = new Board(size);
        this.currentStone = 'W';
        this.mover = new Mover(board);
    }

    @Override
    public String toString(){
        return BoardPrinter.boardPrinter(board);
    }

    public void move(Integer row, Integer column) {
        try {

            mover.move(board, row, column, currentStone);
            currentStone = nextPlayer();

        }catch (OutOfBoundsException | NonAdjacentException | OccupiedCellException e) {
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
}
