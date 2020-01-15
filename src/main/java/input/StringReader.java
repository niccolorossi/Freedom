package input;

import java.io.BufferedReader;
import java.io.IOException;

public class StringReader {
    
    private String stringRead;
    
    StringReader (BufferedReader bufferedReader) {
        try {
            stringRead = bufferedReader.readLine();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    String getStringRead() {
        return stringRead;
    }
    
}
