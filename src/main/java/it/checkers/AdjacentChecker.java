package it.checkers;

import it.freedom.exceptions.NonAdjacentException;

import java.util.Arrays;

public class AdjacentChecker {
    
    public static void adjacentCheck(Integer previousRow, Integer previousColumn,
                              Integer row, Integer column) throws NonAdjacentException {
        if((row < previousRow - 1 || row > previousRow + 1 || column < previousColumn - 1 || column > previousColumn + 1)
        && previousColumn != -1 && previousRow != -1) {
            String message = "This move must be adjacent to " + Arrays.asList(previousRow, previousColumn).toString() + "!";
            throw new NonAdjacentException(message);
        }
    }
}
