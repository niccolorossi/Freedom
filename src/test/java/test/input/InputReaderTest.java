package test.input;

import input.InputReader;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InputReaderTest {

    private final int[] firstCell = {1,1};
    private final int[] invalidMove = {-1, -1};

    @Test
     public void playFirstCell() throws IOException {
        String string = "1 1";
        InputStream stringStream = new ByteArrayInputStream(string.getBytes());

        InputReader inputReader = new InputReader(stringStream);

        int[] firstMove = inputReader.getMove();

        assertThat(firstMove, is(firstCell));
    }

    @Test
    public void whenNotIntegerInputThrowsException() {

        String string = "e 1";

        InputStream stringStream = new ByteArrayInputStream(string.getBytes());
        InputReader inputReader = new InputReader(stringStream);
        int[] move = inputReader.getMove();
        assertThat(move, is(invalidMove));
    }


}
