package winningtest;

import org.junit.Before;
import org.junit.Test;
import winningnic.DiagonalQuadruplet;
import winningnic.HorizontalQuadruplet;
import winningnic.LiveStonesBoard;
import winningnic.VerticalQuadruplet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RetrieveQuadrupletsTest {

    private Character[][] fullBoard;
    private Boolean[][] liveStonesBoardAfterOneQ;

    @Before
    public void initFullBoard(){

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
        
        liveStonesBoardAfterOneQ = new Boolean[][]
                                {{false, false, false, false, false, false, false, false, false, false},
                                {false, false, false, false, false, false, false, false, false, false},
                                {false, false, false, false, false, false, false, false, false, false},
                                {false, false, false, false, false, false, false, false, false, false},
                                {false, false, false, false, false, false, false, false, false, false},
                                {false, false, false, false, false, false, false, false, false, false},
                                {false, false, false, false, false, false, false, false, false, false},
                                {false, false, false, false, false, false, false, false, false, false},
                                {true, true, true, true, false, false, false, false, false, false},
                                {false, false, false, false, false, false, false, false, false, false}};
                
    }
    
    @Test
    public void doINeedToCheckHorizontalQuadrupletElementZeroZero() {
        HorizontalQuadruplet horizontalQuadruplet = new HorizontalQuadruplet(fullBoard, 0, 0);
        assertThat(horizontalQuadruplet.isQuadrupletACandidate(), is(false));
    }

    @Test
    public void doINeedToCheckVerticalQuadrupletElementZeroZero() {
        VerticalQuadruplet verticalQuadruplet = new VerticalQuadruplet(fullBoard, 0, 0);
        assertThat(verticalQuadruplet.isQuadrupletACandidate(), is(true));
    }

    @Test
    public void doINeedToCheckDiagonalQuadrupletElementZeroZero() {
        DiagonalQuadruplet diagonalQuadruplet = new DiagonalQuadruplet(fullBoard, 0, 0);
        assertThat(diagonalQuadruplet.isQuadrupletACandidate(), is(true));
    }

    @Test
    public void doINeedToCheckHorizontalQuadrupletElementZeroOne() {
        HorizontalQuadruplet horizontalQuadruplet = new HorizontalQuadruplet(fullBoard, 0, 1);
        assertThat(horizontalQuadruplet.isQuadrupletACandidate(), is(true));
    }
    
    @Test
    public void doINeedToCheckHorizontalQuadrupletElementZeroFive() {
        HorizontalQuadruplet horizontalQuadruplet = new HorizontalQuadruplet(fullBoard, 0, 5);
        assertThat(horizontalQuadruplet.isQuadrupletACandidate(), is(false));
    }
    
    @Test
    public void testValidQuadruplet() {
        HorizontalQuadruplet horizontalQuadruplet = new HorizontalQuadruplet(fullBoard, 8, 0);
        assertThat(horizontalQuadruplet.isQuadrupletValid('B'), is(true));
    }
    
    @Test
    public void testLiveStones() {
        HorizontalQuadruplet horizontalQuadruplet = new HorizontalQuadruplet(fullBoard, 8, 0);
        LiveStonesBoard liveStonesBoard = new LiveStonesBoard(fullBoard.length);
        liveStonesBoard.setStones(horizontalQuadruplet);
        Boolean[][] currentBoard = liveStonesBoard.getCurrentBoard();
        assertThat(currentBoard, is(liveStonesBoardAfterOneQ));
    }
      
    
}
