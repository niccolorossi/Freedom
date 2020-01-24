package output;

import game.Board;

import java.util.Arrays;
import java.util.function.Consumer;

public class BoardAsString {

    public String parsedBoard(Board board) {

        Character[][] currentBoard = board.currentBoard();
        StringBuilder toReturn = new StringBuilder();

        Consumer<Character[]> pipeDelimiter = (row) -> {
            Arrays.stream(row).forEach((el) -> toReturn.append("|").append(el));
            toReturn.append("|" +"\n");
        };

        Arrays.stream(currentBoard)
                .forEach(pipeDelimiter);

        return toReturn.toString();
    }

}
