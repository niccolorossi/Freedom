package test.input;

import input.InputReader;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InputReaderTest {

    private final List<Integer> firstCell = Arrays.asList(1,1);
    private final Integer boardTenSize = 10;
    private final Integer boardEightSize = 8;
    
    @Test
     public void playFirstCell() {

        String stringMove = "1 1";
        InputReader inputReader = new InputReader(stringMove);
        List<Integer> firstMove = inputReader.getMove(boardTenSize);
        assertThat(firstMove, is(firstCell));
    }

    @Test
    public void whenNotIntegerInputAnExceptionIsCaught() {

        String stringMove = "e 1";
        InputReader inputReader = new InputReader(stringMove);
        inputReader.getMove(boardTenSize);
    }
    
    @Test
    public void whenOutOfBoundsAnExceptionIsCaught() {
        
        String stringMove = "11 1";
        InputReader inputReader = new InputReader(stringMove);
        inputReader.getMove(boardTenSize);
    }
    
    @Test
    public void getMoveWorksWithBoardWithSizeDifferentThanTen() {

        String stringMove = "9 1";
        InputReader inputReader = new InputReader(stringMove);
        inputReader.getMove(boardEightSize);
    }

    @Test
    public void whenSingleInputAnExceptionIsCaught() {

        String stringMove = "1 ";
        InputReader inputReader = new InputReader(stringMove);
        inputReader.getMove(boardEightSize);
    }
}
