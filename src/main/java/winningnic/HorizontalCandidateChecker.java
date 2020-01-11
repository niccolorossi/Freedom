package winningnic;

public class HorizontalCandidateChecker {
    
    private static final Integer nextQuadrupletOffset = 4;
    private Boolean isCandidate;
    
    public HorizontalCandidateChecker(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        this.isCandidate = (fullBoard[beginRow][beginColumn] != fullBoard[beginRow][beginColumn+nextQuadrupletOffset]);
    }
    
    public Boolean getIsCandidate() {
        return this.isCandidate;
    }
}
