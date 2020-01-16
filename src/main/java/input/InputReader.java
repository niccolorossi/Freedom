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
        MoveInBoundsValidator moveInBoundsValidator = new MoveInBoundsValidator(boardSize, parsedIntegers);
        return moveInBoundsValidator.getMove();
    }
}
