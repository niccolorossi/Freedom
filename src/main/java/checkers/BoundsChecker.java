package checkers;

import exceptions.OutOfBoundsException;

public class BoundsChecker {
    
    private Integer lowLimit;
    private Integer upperLimit;
    
    public BoundsChecker(Integer boardSize){
        this.lowLimit = 1;
        this.upperLimit = boardSize;
    }
    
    public Boolean checkCoordinate(Integer coordinate){
        return coordinate < lowLimit || coordinate > upperLimit;
    }
    
    public void boundsCheck(Integer row, Integer column) throws OutOfBoundsException {
        if(checkCoordinate(row) || checkCoordinate(column)) {
            String message = "Coordinate is out of bounds!";
            throw new OutOfBoundsException(message);
        }
    }
}
