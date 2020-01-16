package test.winning;

import org.junit.Before;
import org.junit.Test;
import winning.Points;
import winning.Winner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class WinnerTest {

    private Character[][] fullBoard;
    private Character[][] fullBoardDraw;

    @Before
    public void initFullBoard() {

        fullBoard = new Character[][]
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


        fullBoardDraw = new Character[][]
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




    }

    @Test
    public void blackScoreis23() {
        Points pc = new Points(fullBoard);
        assertThat(pc.getBlackPoints(), is(23));
    }

    @Test
    public void blackScoreIsTheSameAsWhite() {
        Points pc = new Points(fullBoardDraw);
        Integer blackPoints = pc.getBlackPoints();
        Integer whitePoints = pc.getWhitePoints();

        assertEquals(blackPoints, whitePoints);
    }

    @Test
    public void whiteScoreis15() {
        Points pc = new Points(fullBoard);
        assertThat(pc.getWhitePoints(), is(15));
    }

    @Test
    public void blackIsWinner() {
        Winner winner = new Winner(fullBoard);
        assertThat(winner.getWinner(), is("15 - 23 : Black won!"));
    }

    @Test
    public void theGameIsDrawn() {
        Winner winner = new Winner(fullBoardDraw);
        assertThat(winner.getWinner(), is("40 - 40 : the game is drawn!"));
    }
}
