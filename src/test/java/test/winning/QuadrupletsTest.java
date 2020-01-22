
package test.winning;

import game.Board;
import org.junit.Before;
import org.junit.Test;
import winning.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class QuadrupletsTest {

    private Character[][] fullBoardCharacter;
    private Board fullBoard;
    
    private Boolean[][] fullLiveStonesBoard;

    @Before
    public void initFullBoard() {

        fullBoardCharacter = new Character[][]
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

        fullLiveStonesBoard = new Boolean[][]
                        {{false, false, false, false, true, false, false, false, false, false},
                        {false, false, false, true, false, false, true, false, false, false},
                        {false, false, true, false, true, false, true, false, false, false},
                        {false, true, false, true, false, false, true, false, false, false},
                        {false, false, true, false, false, false, true, true, false, false},
                        {false, true, false, false, false, false, false, false, true, false},
                        {false, false, false, false, false, false, false, false, false, true},
                        {false, false, false, false, false, false, false, false, false, false},
                        {true, true, true, true, false, false, true, true, true, true},
                        {false, false, false, false, false, false, false, false, false, false}};

        fullBoard = new Board(fullBoardCharacter);
    }

    @Test
    public void testAllHorizontalVerticalDiagonalAntiQuadrupletsAreSet() {
        LiveStonesBoard liveStonesBoard = new LiveStonesBoard(fullBoard, 'B');
        liveStonesBoard.aliveStonesForCurrentPlayer();
        assertThat(liveStonesBoard.getCurrentBoard(), is(fullLiveStonesBoard));
    }
}
