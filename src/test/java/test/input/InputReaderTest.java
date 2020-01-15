package test.input;

import input.InputReader;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InputReaderTest {

    private final List<Integer> firstCell = Arrays.asList(1,1);
    private final List<Integer> invalidMove = Arrays.asList(-1,-1);
    private InputReader inputReaderTen;
    private InputReader inputReaderEight;
    private final Integer boardTenSize = 10;
    private final Integer boardEightSize = 8;

    /*
    @Before
    public void before(){

        this.inputReaderEight = new InputReader(boardEightSize);
        this.inputReaderTen = new InputReader(boardTenSize);
    }
    
     */

    @Test
     public void playFirstCell() {

        String stringMove = "1 1";
        InputReader inputReader = new InputReader(stringMove);
        List<Integer> firstMove = inputReader.getMove(boardTenSize);
        assertThat(firstMove, is(firstCell));
    }
/*
    @Test
    public void whenNotIntegerInputAnExceptionIsCaught() {

        String string = "e 1";
        InputStream stringStream = new ByteArrayInputStream(string.getBytes());
        int[] move = inputReaderTen.getMove(stringStream);
        assertThat(move, is(invalidMove));
    }
    
    @Test
    public void whenOutOfBoundsAnExceptionIsCaught() {
        
        String string = "11 1";
        InputStream stringStream = new ByteArrayInputStream(string.getBytes());
        int[] move = inputReaderTen.getMove(stringStream);
        assertThat(move, is(invalidMove));
    }

    @Test
    public void getMoveWorksWithBoardWithSizeDifferentThanTen() {

        String string = "9 1";
        InputStream stringStream = new ByteArrayInputStream(string.getBytes());
        int[] move = inputReaderEight.getMove(stringStream);
        assertThat(move, is(invalidMove));
    }

    @Test
    public void whenSingleInputAnExceptionIsCaught() {

        String string = "1 ";
        InputStream stringStream = new ByteArrayInputStream(string.getBytes());
        int[] move = inputReaderTen.getMove(stringStream);
        assertThat(move, is(invalidMove));
    }

*/


}
