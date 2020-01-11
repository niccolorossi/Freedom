package winningnic;

public class HorizontalCandidateChecker extends QuadrupletCandidateChecker {

    public HorizontalCandidateChecker(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        super(fullBoard, beginRow, beginColumn);
        this.isCandidate = (fullBoard[beginRow][beginColumn] != fullBoard[beginRow][beginColumn+nextQuadrupletOffset]);
    }
}
