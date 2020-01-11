package winningnic;

public class VerticalCandidateChecker extends QuadrupletCandidateChecker {

    public VerticalCandidateChecker(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        super(fullBoard, beginRow, beginColumn);
        this.isCandidate = (fullBoard[beginRow][beginColumn] != fullBoard[beginRow+nextQuadrupletOffset][beginColumn]);
    }
}
