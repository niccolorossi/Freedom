package test.game;

import game.GameStatus;
import game.RegularMove;
import game.freedom.NextMoveFreedom;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FreedomMoveTest {

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
            "|_|_|_|_|_|_|_|_|\n";

    private GameStatus gameSizeTenBoard;
    private GameStatus gameSizeEightBoard;

    @Before
    public void startGame() {
        gameSizeTenBoard = new GameStatus(10);
        gameSizeEightBoard = new GameStatus(8);
    }

    @Test
    public void testNextMoveIsFreedom() {
        gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(1,1), 'W'));
        gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(1,2), 'B'));
        gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(1,3), 'W'));
        gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(2,3), 'B'));
        gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(3,3), 'W'));
        gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(3,2), 'B'));
        gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(3,1), 'W'));
        gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(2,1), 'B'));
        gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(2,2), 'W'));

        NextMoveFreedom freedomFinder = new NextMoveFreedom(gameSizeTenBoard.getBoard(), 2, 2);
        assertThat(freedomFinder.isNextFreedom(), is(true));

    }


    @Test
    public void testNextMoveIsFreedomBorder() {
        gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(1,1), 'W'));
        gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(2,1), 'B'));
        gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(3,1), 'W'));
        gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(3,2), 'B'));
        gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(3,3), 'W'));
        gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(2,3), 'B'));
        gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(1,3), 'W'));

        NextMoveFreedom freedomFinder = new NextMoveFreedom(gameSizeTenBoard.getBoard(), 1,3);
        assertThat(freedomFinder.isNextFreedom(), is(false) );    }
        
 
}
