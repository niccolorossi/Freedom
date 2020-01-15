package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class InputReader {

    private InputStream inputStream;

    public InputReader(InputStream stringStream) {
        this.inputStream = stringStream;
    }

    public int[] getMove() throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(inputStream));

        String moveString = reader.readLine();



        int[] move = Stream.of(moveString.split(" ")).mapToInt(Integer::parseInt).toArray();

        return move;
    }
}
