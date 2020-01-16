package input;

import java.io.*;

class BufferedReaderInitializer {
    
    private BufferedReader bufferedReader;
    
    BufferedReaderInitializer(String inputLine) {

        InputStream stringStream = new ByteArrayInputStream(inputLine.getBytes());
        InputStreamReader inputStreamReader = new InputStreamReader(stringStream);
        this.bufferedReader = new BufferedReader(inputStreamReader);
    }

    BufferedReader getBufferedReader() {
        return this.bufferedReader;
    }
}
