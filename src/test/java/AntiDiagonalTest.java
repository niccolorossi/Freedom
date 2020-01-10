import winning.AntiDiagonalExtractor;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AntiDiagonalTest {

    private Character[][] fullBoard;
    private Character[] mainAntiDiagonal;
    private Character[] firstUpperAntiDiagonal;
    private Character[] thirdUpperAntiDiagonal;
    private Character[] thirdLowerAntiDiagonal;

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

        mainAntiDiagonal = new Character[] {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'B', 'W'};
        firstUpperAntiDiagonal = new Character[] {'B', 'B', 'B', 'W', 'W', 'B', 'B', 'W', 'B'};
        thirdUpperAntiDiagonal = new Character[] {'W', 'W', 'B', 'B', 'B', 'B', 'W'};
        thirdLowerAntiDiagonal = new Character[] {'W', 'W', 'B', 'B', 'B', 'W', 'W'};
    }

    @Test
    public void mainDiagonalExtractor() {
        List<Character[]> diagonals = AntiDiagonalExtractor.extractAntiDiagonals(fullBoard);
        assertThat(diagonals.get(12), is(mainAntiDiagonal));
    }

    @Test
    public void thirdUpperDiagonalExtractor() {
        List<Character[]> diagonals = AntiDiagonalExtractor.extractAntiDiagonals(fullBoard);
        assertThat(diagonals.get(2), is(thirdUpperAntiDiagonal));
    }

    @Test
    public void thirdLowerDiagonalExtractor() {
        List<Character[]> diagonals = AntiDiagonalExtractor.extractAntiDiagonals(fullBoard);
        assertThat(diagonals.get(8), is(thirdLowerAntiDiagonal));
    }

}
