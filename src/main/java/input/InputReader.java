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
    private BoundsChecker boundsChecker;

    public InputReader(Integer boardSize){
        this.boardSize = boardSize;
        boundsChecker = new BoundsChecker(boardSize);

    }

    public int[] getMove(InputStream stringStream) {

        try {
            String inputString = streamConvert(stringStream);
            int[] move = Stream.of(inputString.split(" ")).mapToInt(Integer::parseInt).toArray();
            boundsChecker.boundsCheck(move[0], move[1]);
            return move;
        } catch (NumberFormatException  e) {
            System.out.println("You must insert two integers!");
            
        } catch (OutOfBoundsException e1) {
            System.out.println(e1.getMessage());
        }
        
        catch (ArrayIndexOutOfBoundsException e2) {
            System.out.println("You must insert two coordinates");
            
        }

        return new int[] {-1, -1};
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
