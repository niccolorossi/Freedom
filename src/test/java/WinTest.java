import Win.WinningRules;
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
                {'B', 'B', 'B', 'B', 'B', 'W', 'B', 'B', 'B', 'B'},
                {'W', 'B', 'W', 'W', 'B', 'B', 'W', 'W', 'W', 'B'}};
    }
    
    @Test
    public void testHorizontalBlackCount(){
        assertThat(WinningRules.countHorizontal(fullBoard, 'B'), is(8));
    }
    
    @Test
    public void testVerticalBlackCount(){
        assertThat(WinningRules.countVertical(fullBoard, 'B'), is(4));
    }
}
