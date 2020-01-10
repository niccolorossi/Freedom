import org.junit.Test;

import static Win.WinningRules.countQuadrupletsInArray;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CountQuadrupletTest {
    
    @Test
    public void countBlackQuadrupletsInSizeTenArray() {
        Character[] sizeTenArray = {'W', 'B', 'B', 'B', 'B', 'W', 'B', 'B', 'B', 'B'};
        assertThat(countQuadrupletsInArray(sizeTenArray, 'B'), is(8));
    }

    @Test
    public void countBlackQuadrupletsInSizeFourArray() {
        Character[] sizeFourArray = {'B', 'B', 'B', 'B'};
        assertThat(countQuadrupletsInArray(sizeFourArray, 'B'), is(4));
    }
}
