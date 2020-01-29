package game.checkers;

import exceptions.NonAdjacentException;

import java.util.Arrays;
import java.util.List;

class ValidateAdjacentCoordinate {
    
    private Integer previousRow;
    private Integer previousColumn;

    ValidateAdjacentCoordinate(Integer previousRow, Integer previousColumn) {
        this.previousRow = previousRow;
        this.previousColumn = previousColumn;
    }

    void coordinateAdjacent(List<Integer> coordinates) throws NonAdjacentException {

        if(isPreviousRowNotAdjacentTo(coordinates.get(0)) || isPreviousColNotAdjacentTo(coordinates.get(1))) {
            String message = "This move must be adjacent to " + Arrays.asList(previousRow + 1, previousColumn + 1);
            throw new NonAdjacentException(message);
        }
    }

    private Boolean isPreviousRowNotAdjacentTo(Integer currentRow) {
        return (currentRow < previousRow - 1 || currentRow > previousRow + 1);
    }

    private Boolean isPreviousColNotAdjacentTo(Integer currentColumn) {
        return (currentColumn < previousColumn - 1 || currentColumn > previousColumn + 1);
    }
    
}
