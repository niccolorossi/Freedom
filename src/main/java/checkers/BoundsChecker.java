package checkers;

import exceptions.OutOfBoundsException;

public class BoundsChecker {
    
    private Integer lowLimit;
    private Integer upperLimit;
    
    public BoundsChecker(Integer boardSize){
        this.lowLimit = 1;
        this.upperLimit = boardSize;
    }
    
    public void boundsCheck(Integer coordinate) throws OutOfBoundsException {
        if(coordinate < lowLimit || coordinate > upperLimit) {
            String message = coordinate.toString() + " is out of bounds!";
            throw new OutOfBoundsException(message);
        }
    }
}
