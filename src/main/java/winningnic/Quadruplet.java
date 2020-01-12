package winningnic;

import java.util.Arrays;

abstract class Quadruplet {
    
    static final Integer nextQuadrupletOffset = 4;
    static final Integer previousQuadrupletOffset = - 1;
    
    Character[] quadruplet;

    Integer boardSize;
    
    Boolean isQuadrupletAtBeginning;
    Boolean isQuadrupletAtEnd;
    
    Integer beginRow;
    Integer beginColumn;
    
    Character previousElement;
    Character nextElement;
     
    Quadruplet(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        this.boardSize = fullBoard[0].length;
        this.beginRow = beginRow;
        this.beginColumn = beginColumn;
        
    }
    
    Boolean checkPreviousQuadruplet() {
        return quadruplet[0] != previousElement;
    }

    Boolean checkNextQuadruplet() {
        return quadruplet[0] != nextElement;
    }
    
    public Boolean isQuadrupletACandidate() {
        if(isQuadrupletAtBeginning) {
            return checkNextQuadruplet();
        } else if(isQuadrupletAtEnd) {
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
