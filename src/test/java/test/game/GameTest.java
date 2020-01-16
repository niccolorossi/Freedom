package test.game;

import game.Game;
import org.junit.Before;
import org.junit.Test;

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

    private Game gameSizeTenBoard;
    private Game gameSizeEightBoard;

    @Before
    public void startGame(){
        gameSizeTenBoard = new Game(10);
        gameSizeEightBoard = new Game(8);
    }

 
    



    

    
    
}
