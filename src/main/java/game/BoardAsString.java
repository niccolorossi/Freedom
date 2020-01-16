package game;

import java.util.Arrays;
import java.util.function.Consumer;

class BoardAsString {

    public String parsedBoard(Board board) {

        Character[][] currentBoard = board.getCurrentBoard();
        StringBuilder toReturn = new StringBuilder();

        Consumer<Character[]> pipeDelimiter = (row) -> {
            Arrays.stream(row).forEach((el) -> toReturn.append("|" + el));
            toReturn.append("|" +"\n"); 
        };

        Arrays.stream(currentBoard)
                .forEach((row) -> pipeDelimiter.accept(row));

        return toReturn.toString();
    }
    
}
