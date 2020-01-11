package winningnic;

public class DiagonalCandidateChecker {

    private static final Integer nextQuadrupletOffset = 4;
    private Boolean isCandidate;

    public DiagonalCandidateChecker(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        this.isCandidate = (fullBoard[beginRow][beginColumn] != fullBoard[beginRow+nextQuadrupletOffset][beginColumn+nextQuadrupletOffset]);
    }

    public Boolean getIsCandidate() {
        return this.isCandidate;
    }
    
}
