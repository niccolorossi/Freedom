package winning;

import java.util.List;

abstract class Quadruplet {
    
    static final Integer nextQuadrupletOffset = 4;
    static final Integer previousQuadrupletOffset = - 1;
    
    Boolean isQuadrupletValid;
    Boolean isQuadrupletCandidate;
    
    Integer beginRow;
    Integer beginColumn;
     
    Quadruplet(Integer beginRow, Integer beginColumn) {
        this.beginRow = beginRow;
        this.beginColumn = beginColumn;
    }
    
    public Boolean isQuadrupletACandidate() {
        return isQuadrupletCandidate;
    }
    
    public Boolean isQuadrupletValid(Character currentStone) {
        return isQuadrupletValid;
    }
    
    abstract public List<List<Integer>> getIndices();
}
