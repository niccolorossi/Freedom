package winningnic;

public class DiagonalCandidateChecker extends QuadrupletCandidateChecker {
    
    public DiagonalCandidateChecker(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        super(fullBoard, beginRow, beginColumn);
        this.isCandidate = (fullBoard[beginRow][beginColumn] != fullBoard[beginRow+nextQuadrupletOffset][beginColumn+nextQuadrupletOffset]);
    }
    
}
