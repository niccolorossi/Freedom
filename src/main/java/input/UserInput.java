package input;

import java.io.*;
import java.util.List;

public class UserInput {
    
    private BufferedReader bufferedReader;
    
    public UserInput(String inputLine) {
        BufferedReaderInitializer bufferedReaderInitializer = new BufferedReaderInitializer(inputLine);
        this.bufferedReader = bufferedReaderInitializer.getBufferedReader();
    }

    public UserInput(InputStream inputStream) {
        BufferedReaderInitializer bufferedReaderInitializer = new BufferedReaderInitializer(inputStream);
        this.bufferedReader = bufferedReaderInitializer.getBufferedReader();
    }
    
    private String asString() {
        InputString inputString = new InputString(bufferedReader);
        return inputString.getStringRead();
    }
    
    private List<Integer> inputCoordinates(String readString) {
        MoveCoordinates moveCoordinates = new MoveCoordinates(readString);
        return moveCoordinates.currentMove();
    }
    
    public List<Integer> getMove(Integer boardSize) {
        String readString = this.asString();
        List<Integer> moveCoordinates = inputCoordinates(readString);
        ValidInputMove validInputMove = new ValidInputMove(boardSize, moveCoordinates);
        return validInputMove.currentMove();
    }
}
