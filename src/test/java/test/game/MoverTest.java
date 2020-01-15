package test.game;

import freedom.Game;
import org.junit.Before;
import org.junit.Test;

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

    private Game gameSizeTenBoard;
    private Game gameSizeEightBoard;

    @Before
    public void startGame(){
        gameSizeTenBoard = new Game(10);
        gameSizeEightBoard = new Game(8);
    }

    @Test
    public void whenXOutsideBoardThenOutOfBoundsException() {
        gameSizeTenBoard.move(11,1);
        assertThat(gameSizeTenBoard.toString(), is(emptyBoardSizeTen));
    }

    @Test
    public void whenYOutsideBoardThenOutOfBoundsException() {
        gameSizeTenBoard.move(1,11);
        assertThat(gameSizeTenBoard.toString(), is(emptyBoardSizeTen));
    }

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
}