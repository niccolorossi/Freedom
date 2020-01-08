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

    
    private Boolean checkCoordinate(Integer coordinate, Integer previousCoordinate){
        return (coordinate < previousCoordinate - 1 || coordinate > previousCoordinate + 1 );
    }
    
    public void adjacentCheck(Integer row, Integer column, Boolean isFreedom) throws NonAdjacentException {
        
        Boolean checkRow = checkCoordinate(row, previousRow);
        Boolean checkColumn = checkCoordinate(column, previousColumn);
        
        if((checkRow|| checkColumn) && !isFreedom) {
            String message = "This move must be adjacent to " + Arrays.asList(previousRow, previousColumn).toString() + "!";
            throw new NonAdjacentException(message);
        } else setPreviousCoordinates(row, column);
    }
}
