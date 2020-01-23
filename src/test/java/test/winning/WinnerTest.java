package test.winning;

import game.Board;
import org.junit.Before;
import org.junit.Test;
import winning.Points;
import winning.Winner;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class WinnerTest {

    private Board fullBoard;
    private Board fullBoardDraw;

    @Before
    public void initFullBoard() {

        Character[][] fullBoardCharacter = new Character[][]
                {{'B', 'W', 'B', 'W', 'B', 'B', 'W', 'W', 'B', 'W'},
                        {'B', 'W', 'B', 'B', 'W', 'W', 'B', 'B', 'B', 'W'},
                        {'W', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'B'},
                        {'B', 'B', 'W', 'B', 'B', 'W', 'B', 'W', 'W', 'W'},
                        {'W', 'W', 'B', 'W', 'W', 'W', 'B', 'B', 'W', 'B'},
                        {'B', 'B', 'W', 'B', 'B', 'W', 'W', 'B', 'B', 'W'},
                        {'W', 'W', 'B', 'W', 'W', 'B', 'B', 'W', 'B', 'B'},
                        {'W', 'W', 'B', 'W', 'W', 'B', 'W', 'W', 'W', 'W'},
                        {'B', 'B', 'B', 'B', 'W', 'W', 'B', 'B', 'B', 'B'},
                        {'W', 'B', 'W', 'W', 'B', 'B', 'W', 'W', 'W', 'B'}};


        Character[][] fullBoardDrawCharacter = new Character[][]
                {{'B', 'B', 'B', 'B', 'W', 'B', 'W', 'W', 'W', 'W'},
                        {'B', 'B', 'B', 'B', 'W', 'B', 'W', 'W', 'W', 'W'},
                        {'B', 'B', 'B', 'B', 'W', 'B', 'W', 'W', 'W', 'W'},
                        {'B', 'B', 'B', 'B', 'W', 'B', 'W', 'W', 'W', 'W'},
                        {'B', 'B', 'B', 'B', 'W', 'B', 'W', 'W', 'W', 'W'},
                        {'B', 'B', 'B', 'B', 'W', 'B', 'W', 'W', 'W', 'W'},
                        {'B', 'B', 'B', 'B', 'W', 'B', 'W', 'W', 'W', 'W'},
                        {'B', 'B', 'B', 'B', 'W', 'B', 'W', 'W', 'W', 'W'},
                        {'B', 'B', 'B', 'B', 'W', 'B', 'W', 'W', 'W', 'W'},
                        {'B', 'B', 'B', 'B', 'W', 'B', 'W', 'W', 'W', 'W'}};


        fullBoard = new Board(fullBoardCharacter);
        fullBoardDraw = new Board(fullBoardDrawCharacter);
    }

    @Test
    public void blackScoreis23() {
        Points blackPoints = new Points(fullBoard, 'B');
        assertThat(blackPoints.getScore(), is(23));
    }

    @Test
    public void blackScoreIsTheSameAsWhite() {
        Points blackPoints = new Points(fullBoardDraw, 'B');
        Points whitePoints = new Points(fullBoardDraw, 'W');

        Integer blackScore = blackPoints.getScore();
        Integer whiteScore = whitePoints.getScore();

        assertEquals(blackScore, whiteScore);
    }

    @Test
    public void whiteScoreis15() {
        Points whitePoints = new Points(fullBoard, 'W');
        assertThat(whitePoints.getScore(), is(15));
    }

    @Test
    public void blackIsWinner() {
        Winner winner = new Winner(fullBoard);
        assertThat(winner.getWinner(), is(Arrays.asList(15, 23)));
    }

    @Test
    public void theGameIsDrawn() {
        Winner winner = new Winner(fullBoardDraw);
        assertThat(winner.getWinner(), is(Arrays.asList(40, 40)));
    }
}
