package freedom;

import checkers.BoundsChecker;
import checkers.MoveValidator;
import exceptions.NonAdjacentException;
import exceptions.OccupiedCellException;
import exceptions.OutOfBoundsException;

import java.util.stream.Stream;

public class Game {
    
    private Board board;
    private Character currentStone;
    private MoveValidator moveValidator;
    private BoundsChecker boundsChecker;

    public Game(int size) {
        this.board = new Board(size);
        this.currentStone = 'W';
        this.boundsChecker = new BoundsChecker(size);
        this.moveValidator = new MoveValidator(board.getEmptyCellCharacter());
    }

    @Override
    public String toString(){
        return BoardPrinter.boardPrinter(board);
    }

    public void move(Integer row, Integer column) {
        try {
            boundsChecker.boundsCheck(row);
            boundsChecker.boundsCheck(column);
            Character cellStone = board.getStone(row, column);
            moveValidator.validateMove(row, column,cellStone);
            board.setStone(currentStone, row, column);
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

    public Boolean isNextMoveFreedom(Integer row, Integer column) {

        Character[][] currentBoard = board.getCurrentBoard();
        Character empty = board.getEmptyCellCharacter();
        return !Stream.of(row-2, row- 1, row ).flatMap(x -> Stream.of(currentBoard[x][column-2], currentBoard[x][column-1], currentBoard[x][column]))
                .anyMatch(x -> x == empty);
    }
}
