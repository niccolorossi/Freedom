package winningnic;

import java.util.Arrays;

abstract class Quadruplet {
    
    static final Integer nextQuadrupletOffset = 4;
    static final Integer previousQuadrupletOffset = - 1;
    
    Character[] quadruplet;
    
    Boolean isQuadrupletAtBeginning;
    Boolean isQuadrupletAtEnd;
    
    Integer beginRow;
    Integer beginColumn;
    
    Character previousElement;
    Character nextElement;
     
    Quadruplet(Integer beginRow, Integer beginColumn) {
        this.beginRow = beginRow;
        this.beginColumn = beginColumn;
    }
    
    private Boolean checkPreviousQuadruplet() {
        return quadruplet[0] != previousElement;
    }

    private Boolean checkNextQuadruplet() {
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

    public Character[] getQuadruplet() {
        return quadruplet;
    }
    
}
