package winningnic;

public class VerticalCandidateChecker {

    private static final Integer nextQuadrupletOffset = 4;
    private Boolean isCandidate;

    public VerticalCandidateChecker(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        this.isCandidate = (fullBoard[beginRow][beginColumn] != fullBoard[beginRow+nextQuadrupletOffset][beginColumn]);
    }

    public Boolean getIsCandidate() {
        return this.isCandidate;
    }
}
