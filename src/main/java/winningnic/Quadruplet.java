package winningnic;

abstract class Quadruplet {
    
    static final Integer nextQuadrupletOffset = 4;
    static final Integer previousQuadrupletOffset = - 1;
    
    Character[][] fullBoard;
    Integer beginRow;
    Integer beginColumn;
     
    Quadruplet(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        this.fullBoard = fullBoard;
        this.beginRow = beginRow;
        this.beginColumn = beginColumn;
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
    
}
