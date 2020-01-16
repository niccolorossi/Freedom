package input;

import exceptions.OutOfBoundsException;

class ValidateCoordinateInBounds {
    
    private Integer coordinate;
    
    ValidateCoordinateInBounds(Integer coordinate) {
        this.coordinate = coordinate;
    }
    
    Boolean validate(Integer boardSize) throws OutOfBoundsException {
        if(coordinate < 1 || coordinate > boardSize) {
            throw new OutOfBoundsException("You must insert two numbers in the range 1-10!");
        }
        else return true;
    }
    
}
