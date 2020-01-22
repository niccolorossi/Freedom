package test.game;

import game.GameStatus;
import game.RegularMove;
import game.freedom.NextMoveFreedom;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FreedomMoveTest {

    private GameStatus gameStatus;

    @Before
    public void startGame() {
        gameStatus = new GameStatus(10);
    }

    @Test
    public void testNextMoveIsFreedom() {
        gameStatus.updateStatus(new RegularMove(Arrays.asList(1,1), 'W'));
        gameStatus.updateStatus(new RegularMove(Arrays.asList(1,2), 'B'));
        gameStatus.updateStatus(new RegularMove(Arrays.asList(1,3), 'W'));
        gameStatus.updateStatus(new RegularMove(Arrays.asList(2,3), 'B'));
        gameStatus.updateStatus(new RegularMove(Arrays.asList(3,3), 'W'));
        gameStatus.updateStatus(new RegularMove(Arrays.asList(3,2), 'B'));
        gameStatus.updateStatus(new RegularMove(Arrays.asList(3,1), 'W'));
        gameStatus.updateStatus(new RegularMove(Arrays.asList(2,1), 'B'));
        gameStatus.updateStatus(new RegularMove(Arrays.asList(2,2), 'W'));

        NextMoveFreedom freedomFinder = new NextMoveFreedom(gameStatus.getBoard(), 2, 2);
        assertThat(freedomFinder.isNextFreedom(), is(true));

    }


    @Test
    public void testNextMoveIsFreedomBorder() {
        gameStatus.updateStatus(new RegularMove(Arrays.asList(1,1), 'W'));
        gameStatus.updateStatus(new RegularMove(Arrays.asList(2,1), 'B'));
        gameStatus.updateStatus(new RegularMove(Arrays.asList(3,1), 'W'));
        gameStatus.updateStatus(new RegularMove(Arrays.asList(3,2), 'B'));
        gameStatus.updateStatus(new RegularMove(Arrays.asList(3,3), 'W'));
        gameStatus.updateStatus(new RegularMove(Arrays.asList(2,3), 'B'));
        gameStatus.updateStatus(new RegularMove(Arrays.asList(1,3), 'W'));

        NextMoveFreedom freedomFinder = new NextMoveFreedom(gameStatus.getBoard(), 1,3);
        assertThat(freedomFinder.isNextFreedom(), is(false) );    }
        
 
}
