package input;

import checkers.BoundsChecker;
import exceptions.OutOfBoundsException;

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
            int[] move = Stream.of(inputString.split(" ")).mapToInt(Integer::parseInt).toArray();
            BoundsChecker boundsChecker = new BoundsChecker(10);
            boundsChecker.boundsCheck(move[0], move[1]);
            return move;
        } catch (NumberFormatException | OutOfBoundsException e) {
            System.out.println("You must insert two integers!");
            return new int[] {-1, -1};
        }
    }


}
