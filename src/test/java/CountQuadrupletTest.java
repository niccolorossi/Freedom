import winning.QuadrupletsCounter;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CountQuadrupletTest {
    
    @Test
    public void countBlackQuadrupletsInSizeTenArray() {
        Character[] sizeTenArray = {'W', 'B', 'B', 'B', 'B', 'W', 'B', 'B', 'B', 'B'};
        assertThat(QuadrupletsCounter.countQuadrupletsInArray(sizeTenArray, 'B'), is(8));
    }

    @Test
    public void countBlackQuadrupletsInSizeFourArray() {
        Character[] sizeFourArray = {'B', 'B', 'B', 'B'};
        assertThat(QuadrupletsCounter.countQuadrupletsInArray(sizeFourArray, 'B'), is(4));
    }

    @Test
    public void countBlackQuadrupletsInSizeNineArray() {
        Character[] sizeNineArray = {'B', 'B', 'W', 'W', 'W', 'W', 'B', 'B', 'B'};
        assertThat(QuadrupletsCounter.countQuadrupletsInArray(sizeNineArray, 'W'), is(4));
    }

}
