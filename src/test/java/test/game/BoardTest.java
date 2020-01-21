package test.game;

import game.Board;
import game.GameStatus;
import org.junit.Before;
import org.junit.Test;
import output.BoardAsString;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {
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

    private String emptyBoardSizeEight = "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" ;

    private BoardAsString gameSizeTenBoard;
    private BoardAsString gameSizeEightBoard;

    @Before
    public void startGame() {
        gameSizeTenBoard = new BoardAsString();
        gameSizeEightBoard = new BoardAsString();
    }

    @Test
    public void isSizeTenBoardEmpty() {
        assertThat(gameSizeTenBoard.parsedBoard(new Board(10)) , is(emptyBoardSizeTen));

    }

    @Test
    public void isSizeEightBoardEmpty() {
        assertThat(gameSizeTenBoard.parsedBoard(new Board(8)), is(emptyBoardSizeEight));
    }
}
