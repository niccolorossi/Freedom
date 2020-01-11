package winningnic;

public class QuadrupletCandidateChecker {
    
    static final Integer nextQuadrupletOffset = 4;
    Boolean isCandidate;
    
    private Character[][] fullBoard;
    private Integer beginRow;
    private Integer beginColumn;
     
    public QuadrupletCandidateChecker(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        this.fullBoard = fullBoard;
        this.beginRow = beginRow;
        this.beginColumn = beginColumn;
    } 
    
    public Boolean getIsCandidate() {
        return this.isCandidate;
    }

}
