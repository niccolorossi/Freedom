package input;

import exceptions.OutOfBoundsException;

class ValidateCoordinate {
    
    private Integer coordinate;
    
    ValidateCoordinate(Integer coordinate) {
        this.coordinate = coordinate;
    }
    
    Boolean validate(Integer boardSize) throws OutOfBoundsException {
        if(coordinate < 1 || coordinate > boardSize-1) {
            throw new OutOfBoundsException("You must insert two numbers in the range 1-10!");
        }
        else return true;
    }
    
}
