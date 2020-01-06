package it.freedom;

import it.freedom.exceptions.OutOfBoundsException;

class BoundsChecker {
    
    static void boundsChecker(Integer boardSize, Integer coordinate) throws OutOfBoundsException {
        if(coordinate < 1 || coordinate > boardSize) {
            String message = coordinate.toString() + " is out of bounds!";
            throw new OutOfBoundsException(message);
        }
    }
}
