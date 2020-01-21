package checkers;

import exceptions.NonAdjacentException;

import java.util.Arrays;

public class ValidateAdjacentCoordinate {
    
    private Integer coordinate;
    private Integer previousRow;
    private Integer previousColumn;

    public ValidateAdjacentCoordinate(Integer coordinate) {
        this.coordinate = coordinate;
    }

    public ValidateAdjacentCoordinate(Integer previousRow, Integer previousColumn) {
        this.previousRow = previousRow;
        this.previousColumn = previousColumn;
    }

    public void isCoordinateAdjacent(Integer previousCoordinate) throws NonAdjacentException {
        if(coordinate < previousCoordinate - 1 || coordinate > previousCoordinate + 1) {
            String message = "This move must be adjacent to the previous one!";
            throw new NonAdjacentException(message);
        }
    }

    public void coordinateAdjacent(Integer currentRow, Integer currentColumn) throws NonAdjacentException {

        if( isRowAdjacentTo(currentRow) || isColAdjacentTo(currentColumn)) {
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
