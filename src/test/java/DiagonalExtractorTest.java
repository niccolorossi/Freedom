import winning.DiagonalExtractor;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DiagonalExtractorTest {

    private Character[][] fullBoard;
    private Character[] mainDiagonal;
    private Character[] firstUpperDiagonal;
    private Character[] thirdUpperDiagonal;
    private Character[] thirdLowerDiagonal;

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
        
        mainDiagonal = new Character[] {'B', 'W', 'B', 'B', 'W', 'W', 'B', 'W', 'B', 'B'};
        firstUpperDiagonal = new Character[] {'W', 'B', 'W', 'B', 'W', 'W', 'W', 'W', 'B'};
        thirdUpperDiagonal = new Character[] {'W', 'W', 'W', 'B', 'B', 'B', 'B'};
        thirdLowerDiagonal = new Character[] {'B', 'W', 'W', 'W', 'W', 'W', 'W'};
    }
    
    @Test
    public void mainDiagonalExtractor() {
        List<Character[]> diagonals = DiagonalExtractor.extractDiagonals(fullBoard);
        assertThat(diagonals.get(12), is(mainDiagonal));
    }

    @Test
    public void thirdUpperDiagonalExtractor() {
        List<Character[]> diagonals = DiagonalExtractor.extractDiagonals(fullBoard);
        assertThat(diagonals.get(2), is(thirdUpperDiagonal));
    }

    @Test
    public void thirdLowerDiagonalExtractor() {
        List<Character[]> diagonals = DiagonalExtractor.extractDiagonals(fullBoard);
        assertThat(diagonals.get(8), is(thirdLowerDiagonal));
    }
}
