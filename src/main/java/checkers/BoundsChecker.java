package checkers;

import exceptions.OutOfBoundsException;

public class BoundsChecker {
    
    private Integer lowLimit;
    private Integer upperLimit;
    
    public BoundsChecker(Integer boardSize){
        this.lowLimit = 1;
        this.upperLimit = boardSize;
    }
    
    public void boundsCheck(Integer row, Integer column) throws OutOfBoundsException {
        if(row < lowLimit || row > upperLimit || column < lowLimit || column > lowLimit) {
            String message = "something is out of bounds!";
            throw new OutOfBoundsException(message);
        }
    }
}
