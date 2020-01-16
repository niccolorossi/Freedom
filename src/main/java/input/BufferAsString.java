package input;

import java.io.BufferedReader;
import java.io.IOException;

public class BufferAsString {

    private BufferedReader bufferedReader;

    public BufferAsString(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public String parsedString() {
        try {
            return bufferedReader.readLine();
        } catch(IOException e) {
            System.out.println(e.getMessage());
            return " ";
        }
    }
}
