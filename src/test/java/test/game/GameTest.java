package test.game;

import game.GameState;
import org.junit.Before;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameTest {

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

    private GameState gameSizeTenBoard;
    private GameState gameSizeEightBoard;

    @Before
    public void startGame(){
        gameSizeTenBoard = new GameState(10);
        gameSizeEightBoard = new GameState(8);
    }

 
    



    

    
    
}
