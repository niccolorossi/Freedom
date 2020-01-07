package checkers;

import exceptions.NonAdjacentException;

import java.util.Arrays;

public class AdjacentChecker {
    
    private Integer previousRow;
    private Integer previousColumn;
    
    public AdjacentChecker(Integer row, Integer column){
        this.previousColumn = row;
        this.previousRow = column;
    }
    
    private void setPreviousCoordinates(Integer row, Integer column){
        this.previousRow = row;
        this.previousColumn = column;
    }
    
    
    public void adjacentCheck(Integer row, Integer column) throws NonAdjacentException {
        if((row < previousRow - 1 || row > previousRow + 1 || column < previousColumn - 1 || column > previousColumn + 1)
        && previousColumn != -1 && previousRow != -1) {
            String message = "This move must be adjacent to " + Arrays.asList(previousRow, previousColumn).toString() + "!";
            throw new NonAdjacentException(message);
        } else setPreviousCoordinates(row, column);
    }
}
