package winningnic;

import java.util.Arrays;

abstract class Quadruplet {
    
    static final Integer nextQuadrupletOffset = 4;
    static final Integer previousQuadrupletOffset = - 1;
    
    Character[] quadruplet;
    Character[][] fullBoard;

    Integer boardSize;
    
    Integer beginRow;
    Integer beginColumn;
     
    Quadruplet(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        this.beginRow = beginRow;
        this.beginColumn = beginColumn;
        
        this.fullBoard = fullBoard;
        
        this.boardSize = fullBoard[0].length;
    }
    
    abstract Boolean quadrupleIsAtBeginning();
    abstract Boolean quadrupleIsAtEnd();
    abstract Boolean checkPreviousQuadruplet();
    abstract Boolean checkNextQuadruplet();
    
    public Boolean isQuadrupletACandidate() {
        if(quadrupleIsAtBeginning()) {
            return checkNextQuadruplet();
        } else if(quadrupleIsAtEnd()) {
            return checkPreviousQuadruplet();
        } else {
            return checkPreviousQuadruplet() && checkNextQuadruplet();
        }
    }

    public Boolean isQuadrupletValid(Character currentStone) {
        return Arrays.stream(quadruplet).allMatch(currentStone::equals);
    }
    
    abstract public void setStones(Boolean[][] board);
}
