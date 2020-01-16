package test.winning;

import org.junit.Before;
import org.junit.Test;
import winning.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class QuadrupletsTest {

    private Character[][] fullBoard;
    
    private Boolean[][] liveStonesBoardAfterHorizontalQuadrupletEightZero;
    private Boolean[][] liveStonesBoardAfterHQEightZeroEightSix;
    private Boolean[][] liveStonesBoardAfterSettingHVBlackStones;
    private Boolean[][] liveStonesBoardAfterSettingHVDBlackStones;
    private Boolean[][] liveStonesBoardAfterSettingHVDABlackStones;

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
        
        liveStonesBoardAfterHorizontalQuadrupletEightZero = new Boolean[][]
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

        liveStonesBoardAfterHQEightZeroEightSix = new Boolean[][]
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

        liveStonesBoardAfterSettingHVBlackStones = new Boolean[][]
                        {{false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, true, false, false, false},
                        {false, false, false, false, false, false, true, false, false, false},
                        {false, false, false, false, false, false, true, false, false, false},
                        {false, false, false, false, false, false, true, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false},
                        {true, true, true, true, false, false, true, true, true, true},
                        {false, false, false, false, false, false, false, false, false, false}};

        liveStonesBoardAfterSettingHVDBlackStones = new Boolean[][]
                        {{false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, true, false, false, false},
                        {false, false, false, false, false, false, true, false, false, false},
                        {false, false, false, false, false, false, true, false, false, false},
                        {false, false, false, false, false, false, true, true, false, false},
                        {false, false, false, false, false, false, false, false, true, false},
                        {false, false, false, false, false, false, false, false, false, true},
                        {false, false, false, false, false, false, false, false, false, false},
                        {true, true, true, true, false, false, true, true, true, true},
                        {false, false, false, false, false, false, false, false, false, false}};

        liveStonesBoardAfterSettingHVDABlackStones = new Boolean[][]
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

    }
    
    

    @Test
    public void testAllHorizontalQuadrupletsAreSet() {
        LiveStonesBoard liveStonesBoard = new LiveStonesBoard(fullBoard.length);
        PlayerQuadruplets playerQuadruplets = new PlayerQuadruplets(liveStonesBoard, fullBoard, 'B');
        playerQuadruplets.findHorizontalQuadruplets();
        assertThat(liveStonesBoard.getCurrentBoard(), is(liveStonesBoardAfterHQEightZeroEightSix));
    }

    @Test
    public void testAllHorizontalVerticalQuadrupletsAreSet() {
        LiveStonesBoard liveStonesBoard = new LiveStonesBoard(fullBoard.length);
        PlayerQuadruplets playerQuadruplets = new PlayerQuadruplets(liveStonesBoard, fullBoard, 'B');
        playerQuadruplets.findHorizontalQuadruplets();
        playerQuadruplets.findVerticalQuadruplets();
        assertThat(liveStonesBoard.getCurrentBoard(), is(liveStonesBoardAfterSettingHVBlackStones));
    }

    @Test
    public void testAllHorizontalVerticalDiagonalQuadrupletsAreSet() {
        LiveStonesBoard liveStonesBoard = new LiveStonesBoard(fullBoard.length);
        PlayerQuadruplets playerQuadruplets = new PlayerQuadruplets(liveStonesBoard, fullBoard, 'B');
        playerQuadruplets.findHorizontalQuadruplets();
        playerQuadruplets.findVerticalQuadruplets();
        playerQuadruplets.findDiagonalQuadruplets();
        assertThat(liveStonesBoard.getCurrentBoard(), is(liveStonesBoardAfterSettingHVDBlackStones));
    }

    @Test
    public void testAllHorizontalVerticalDiagonalAntiQuadrupletsAreSet() {
        LiveStonesBoard liveStonesBoard = new LiveStonesBoard(fullBoard.length);
        PlayerQuadruplets playerQuadruplets = new PlayerQuadruplets(liveStonesBoard, fullBoard, 'B');
        playerQuadruplets.findHorizontalQuadruplets();
        playerQuadruplets.findVerticalQuadruplets();
        playerQuadruplets.findDiagonalQuadruplets();
        playerQuadruplets.findAntiDiagonalQuadruplets();
        assertThat(liveStonesBoard.getCurrentBoard(), is(liveStonesBoardAfterSettingHVDABlackStones));
    }
    
    
}
