package test.game;

import game.GameState;
import org.junit.Before;

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
            "|_|_|_|_|_|_|_|_|\n" ;

    private GameState gameSizeTenBoard;
    private GameState gameSizeEightBoard;

    @Before
    public void startGame(){
        gameSizeTenBoard = new GameState(10);
        gameSizeEightBoard = new GameState(8);
    }
/*
    @Test
    public void testNextMoveIsFreedom(){
        gameSizeTenBoard.move(1,1);
        gameSizeTenBoard.move(1,2);
        gameSizeTenBoard.move(1,3);
        gameSizeTenBoard.move(2,3);
        gameSizeTenBoard.move(3,3);
        gameSizeTenBoard.move(3,2);
        gameSizeTenBoard.move(3,1);
        gameSizeTenBoard.move(2,1);
        gameSizeTenBoard.move(2,2);
        
        NextMoveFreedom freedomFinder = new NextMoveFreedom(gameSizeTenBoard.getBoard(), 2,2);
        assertThat(freedomFinder.isNextFreedom(), is(true) );

    }

    @Test
    public void testNextMoveIsFreedomBorder() {
        gameSizeTenBoard.move(1,1);
        gameSizeTenBoard.move(2,1);
        gameSizeTenBoard.move(3,1);
        gameSizeTenBoard.move(3,2);
        gameSizeTenBoard.move(3,3);
        gameSizeTenBoard.move(2,3);
        gameSizeTenBoard.move(1,3);

        NextMoveFreedom freedomFinder = new NextMoveFreedom(gameSizeTenBoard.getBoard(), 1,3);
        assertThat(freedomFinder.isNextFreedom(), is(false) );    }
        
 */
}
