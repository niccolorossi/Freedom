package input;

import java.io.*;
import java.util.List;

public class InputReader {
    
    private BufferedReader bufferedReader;
    
    public InputReader(String inputLine) {
        BufferedReaderInitializer bufferedReaderInitializer = new BufferedReaderInitializer(inputLine);
        this.bufferedReader = bufferedReaderInitializer.getBufferedReader();
    }

    public InputReader(InputStream inputStream) {
        BufferedReaderInitializer bufferedReaderInitializer = new BufferedReaderInitializer(inputStream);
        this.bufferedReader = bufferedReaderInitializer.getBufferedReader();
    }
    
    private String getString() {
        StringReader stringReader = new StringReader(bufferedReader);
        return stringReader.getStringRead();
    }
    
    private List<Integer> getParsedIntegers(String readString) {
        IntegerParser integerParser = new IntegerParser(readString);
        return integerParser.getParsedIntegers();
    }
    
    public List<Integer> getMove(Integer boardSize) {
        String readString = this.getString();
        List<Integer> parsedIntegers = getParsedIntegers(readString);
        MoveInBoundsValidator moveInBoundsValidator = new MoveInBoundsValidator(parsedIntegers);
        moveInBoundsValidator.validateMove(boardSize);
        return parsedIntegers;
    }
    
    
    
    
    
    
    
    
    /*

    private MoveInBoundsValidator boundsChecker;

    public InputReader(Integer boardSize) {
        this.boundsChecker = new MoveInBoundsValidator(boardSize);
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
    
     */


}
