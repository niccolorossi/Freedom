package test.input;

import input.InputReader;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InputReaderTest {

    private final int[] firstCell = {1,1};
    private final int[] invalidMove = {-1, -1};
    private InputReader inputReaderTen;
    private InputReader inputReaderEight;
    private final Integer boardTenSize = 10;
    private final Integer boardEightSize = 8;


    @Before
    public void before(){

        this.inputReaderEight = new InputReader(boardEightSize);
        this.inputReaderTen = new InputReader(boardTenSize);
    }

    @Test
     public void playFirstCell() throws IOException {

        String string = "1 1";
        InputStream stringStream = new ByteArrayInputStream(string.getBytes());
        int[] firstMove = inputReaderTen.getMove(stringStream);
        assertThat(firstMove, is(firstCell));
    }

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




}
