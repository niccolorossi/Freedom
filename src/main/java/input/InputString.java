package input;

import java.io.BufferedReader;

public class InputString {
    
    private BufferAsString bufferAsString;

    InputString(BufferedReader bufferedReader) {

        this.bufferAsString = new BufferAsString(bufferedReader);
    }
    
    String getStringRead() {

        return bufferAsString.parsedString();
    }
    
}
