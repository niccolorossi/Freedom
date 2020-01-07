package it.checkers;

import it.freedom.exceptions.OutOfBoundsException;

public class BoundsChecker {
    
    public static void boundsCheck(Integer boardSize, Integer coordinate) throws OutOfBoundsException {
        if(coordinate < 1 || coordinate > boardSize) {
            String message = coordinate.toString() + " is out of bounds!";
            throw new OutOfBoundsException(message);
        }
    }
}
