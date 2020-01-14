package winningtest;

import org.junit.Before;
import org.junit.Test;
import winning.PointsCounter;
import winning.Winner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WinnerTest {

    private Character[][] fullBoard;
    private PointsCounter pc;

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

        pc = new PointsCounter(fullBoard);



    }

    @Test
    public void blackScoreis23() {

        assertThat(pc.getBlackPoints(), is(23));
    }

    @Test
    public void whiteScoreis15() {

        assertThat(pc.getWhitePoints(), is(15));
    }

    @Test
    public void blackIsWinner() {
        Winner winner = new Winner(fullBoard);
        assertThat(winner.getWinner(), is("15 - 23 : Black won!"));
    }
}
