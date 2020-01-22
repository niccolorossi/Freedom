package test.game;

import game.Board;
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

    private BoardAsString boardAsString;

    @Before
    public void startGame() {
        boardAsString = new BoardAsString();
    }

    @Test
    public void isSizeTenBoardEmpty() {
        assertThat(boardAsString.parsedBoard(new Board(10)) , is(emptyBoardSizeTen));

    }

    @Test
    public void isSizeEightBoardEmpty() {
        assertThat(boardAsString.parsedBoard(new Board(8)), is(emptyBoardSizeEight));
    }
}
