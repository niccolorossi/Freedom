package winningtest;

import org.junit.Before;
import org.junit.Test;
import winning.quadruplets.QuadrupletsCounter;
import winningnic.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RetrieveQuadrupletsTest {

    private Character[][] fullBoard;
    private Boolean[][] liveStonesBoardAfterOneQ;
    private Boolean[][] liveStonesBoardAfterTwoQ;

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

        liveStonesBoardAfterTwoQ = new Boolean[][]
                {{false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false},
                        {true, true, true, true, false, false, true, true, true, true},
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

    @Test
    public void testLiveStonesAfterTwoQ() {
        HorizontalQuadruplet horizontalQuadrupletOne = new HorizontalQuadruplet(fullBoard, 8, 0);
        HorizontalQuadruplet horizontalQuadrupletTwo = new HorizontalQuadruplet(fullBoard, 8, 6);

        LiveStonesBoard liveStonesBoard = new LiveStonesBoard(fullBoard.length);
        liveStonesBoard.setStones(horizontalQuadrupletOne);
        liveStonesBoard.setStones(horizontalQuadrupletTwo);
        Boolean[][] currentBoard = liveStonesBoard.getCurrentBoard();
        assertThat(currentBoard, is(liveStonesBoardAfterTwoQ));
    }
    
    @Test
    public void testInitializeQuadrupletFromNewClass() {
       HorizontalQuadrupletsGenerator horizontalQuadrupletsGenerator = new HorizontalQuadrupletsGenerator(fullBoard);
       HorizontalQuadruplet horizontalQuadruplet = horizontalQuadrupletsGenerator.generate(0,0);
       HorizontalQuadruplet anotherHorizontalQuadruplet = new HorizontalQuadruplet(fullBoard, 0, 0);
       assertThat(horizontalQuadruplet.getQuadruplet(), is(anotherHorizontalQuadruplet.getQuadruplet()));
        
    }
      
    
}
