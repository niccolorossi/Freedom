package checkers;

import exceptions.NonAdjacentException;

import java.util.Arrays;
import java.util.List;

public class ValidateAdjacentCoordinate {
    
    private Integer previousRow;
    private Integer previousColumn;

    public ValidateAdjacentCoordinate(Integer previousRow, Integer previousColumn) {
        this.previousRow = previousRow;
        this.previousColumn = previousColumn;
    }

    public void coordinateAdjacent(List<Integer> coordinates) throws NonAdjacentException {

        if( isRowAdjacentTo(coordinates.get(0)) || isColAdjacentTo(coordinates.get(1))) {
            String message = "This move must be adjacent to " + Arrays.asList(previousRow, previousColumn);
            throw new NonAdjacentException(message);
        }
    }

    private Boolean isRowAdjacentTo(Integer currentRow) {
        return (currentRow < previousRow - 1 || currentRow > previousRow + 1);
    }

    private Boolean isColAdjacentTo(Integer currentColumn) {
        return (currentColumn < previousColumn - 1 || currentColumn > previousColumn + 1);
    }


}
