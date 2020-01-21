package test.game;

import game.GameStatus;
import game.RegularMove;
import org.junit.Before;
import org.junit.Test;
import output.BoardAsString;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MoverTest {

    private String emptyBoardSizeTen = "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n";

    private String firstMoveBoardSizeTen = "|W|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n";

    private String emptyBoardSizeEight = "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" ;

    private GameStatus gameSizeTenBoard;
    private GameStatus gameSizeEightBoard;
    private BoardAsString boardAsString;

    @Before
    public void startGame(){
        gameSizeTenBoard = new GameStatus(10);
        gameSizeEightBoard = new GameStatus(8);
        boardAsString = new BoardAsString();
    }
    
    
    @Test
    public void checkFirstMove() {
        gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(1,1), 'W'));
        assertThat(boardAsString.parsedBoard(gameSizeTenBoard.getBoard()), is(firstMoveBoardSizeTen));
    }

   /* @Test
    public void testOccupiedCellToStringReturnsPreviousBoard() {
        gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(1,1), 'W'));
        gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(1,1), 'B'));
        
        assertThat(boardAsString.parsedBoard(gameSizeTenBoard.getBoard()), is(firstMoveBoardSizeTen));
    }

    @Test
    public void testNonAdjacentCellToStringReturnsPreviousBoard() {
        gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(1,1), 'W'));
        gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(1,4), 'B'));

        assertThat(boardAsString.parsedBoard(gameSizeTenBoard.getBoard()), is(firstMoveBoardSizeTen));
    }*/
    
     
}
