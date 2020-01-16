package checkers;

import exceptions.NonAdjacentException;

public class ValidateAdjacentCoordinate {
    
    private Integer coordinate;

    public ValidateAdjacentCoordinate(Integer coordinate) {
        this.coordinate = coordinate;
    }

    public void validate(Integer previousCoordinate) throws NonAdjacentException {
        if(coordinate < previousCoordinate - 1 || coordinate > previousCoordinate + 1) {
            String message = "This move must be adjacent to the previous one!";
            throw new NonAdjacentException(message);
        }
    }
}
