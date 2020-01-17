package test.game;

import game.GameStatus;
import org.junit.Before;

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

    @Before
    public void startGame(){
        gameSizeTenBoard = new GameStatus(10);
        gameSizeEightBoard = new GameStatus(8);
    }
    
    /*
    @Test
    public void checkFirstMove() {
        gameSizeTenBoard.move(1,1);
        assertThat(gameSizeTenBoard.toString(), is(firstMoveBoardSizeTen));
    }

    @Test
    public void testOccupiedCellToStringReturnsPreviousBoard() {
        gameSizeTenBoard.move(1,1);
        gameSizeTenBoard.move(1,1);
        assertThat(gameSizeTenBoard.toString(), is(firstMoveBoardSizeTen));
    }

    @Test
    public void testNonAdjacentCellToStringReturnsPreviousBoard() {
        gameSizeTenBoard.move(1,1);
        gameSizeTenBoard.move(1,4);

        assertThat(gameSizeTenBoard.toString(), is(firstMoveBoardSizeTen));
    }
    
     */
}
