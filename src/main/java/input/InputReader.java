package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class InputReader {

    private String inputString;

    public InputReader(InputStream stringStream)  {

        try {
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(stringStream));
            inputString = reader.readLine();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public int[] getMove() {

        try {
            return Stream.of(inputString.split(" ")).mapToInt(Integer::parseInt).toArray();
        } catch (NumberFormatException e) {
            System.out.println("You must insert two integers!");
            return new int[] {-1, -1};
        }
    }


}
