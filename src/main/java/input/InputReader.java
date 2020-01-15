package input;

import checkers.BoundsChecker;
import exceptions.OutOfBoundsException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class InputReader {

    private Integer boardSize;

    public InputReader(Integer boardSize){
        this.boardSize = boardSize;
    }

    public int[] getMove(InputStream stringStream) {

        try {
            String inputString = streamConvert(stringStream);
            int[] move = Stream.of(inputString.split(" ")).mapToInt(Integer::parseInt).toArray();
            BoundsChecker boundsChecker = new BoundsChecker(boardSize);
            boundsChecker.boundsCheck(move[0], move[1]);
            return move;
        } catch (NumberFormatException  e) {
            System.out.println("You must insert two integers!");
            return new int[] {-1, -1};
        } catch (OutOfBoundsException e1) {
            System.out.println(e1.getMessage());
            return new int[] {-1, -1};
        }
    }

    private String streamConvert(InputStream stringStream){

        try {
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(stringStream));

            return reader.readLine();
        } catch (IOException e){
            System.out.println(e.getMessage());
            return " ";
        }
    }


}
