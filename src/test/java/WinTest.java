import Win.DiagonalCounter;
import Win.HorizontalCounter;
import Win.TotalPointsCounter;
import Win.VerticalCounter;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WinTest {
    
    private Character[][] fullBoard;
    
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
    }
    
    @Test
    public void testHorizontalBlackCount(){
        assertThat(HorizontalCounter.countHorizontal(fullBoard, 'B'), is(8));
    }
    
    @Test
    public void testVerticalBlackCount(){
        assertThat(VerticalCounter.countVertical(fullBoard, 'B'), is(4));
    }
    
    @Test
    public void testTotalBlackCount() {
        assertThat(TotalPointsCounter.countPoints(fullBoard, 'B'), is(12));
    }

    @Test
    public void testDiagonalBlackCount() {
        assertThat(DiagonalCounter.countDiagonal(fullBoard, 'B'), is(4));
    }
    
}
