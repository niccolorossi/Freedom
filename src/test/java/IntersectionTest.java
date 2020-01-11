import org.junit.Before;
import org.junit.Test;
import winning.RowLive;
import winning.VerticalLive;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IntersectionTest {

    private Character[][] fullBoard;
    private Integer[][] horizontalLive;
    private Integer[][] verticalLive;

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

        horizontalLive = new Integer[][]
                        {{0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {1,1,1,1,0,0,1,1,1,1},
                        {0,0,0,0,0,0,0,0,0,0}};

        verticalLive = new Integer[][]
                       {{0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,1,0,0,0},
                        {0,0,0,0,0,0,1,0,0,0},
                        {0,0,0,0,0,0,1,0,0,0},
                        {0,0,0,0,0,0,1,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0}};
    }

    @Test
    public void testHorizontalBlackCount(){
        RowLive rowAlive = new RowLive(fullBoard, 'B');
        assertThat(rowAlive.getCounter(), is(horizontalLive));
    }

    @Test
    public void testVerticalBlackCount(){
        VerticalLive verticalCount = new VerticalLive(fullBoard, 'B');
        assertThat(verticalCount.getCounter(), is(verticalLive));
    }


}
