package winningnic;

public class DiagonalQuadruplet extends Quadruplet {
    
    public DiagonalQuadruplet(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        super(fullBoard, beginRow, beginColumn);
    }
    
    @Override
    Boolean quadrupleIsAtBeginning() {
        return beginRow == 0 || beginColumn == 0;
    }

    @Override
    Boolean quadrupleIsAtEnd() {
        return beginRow == fullBoard[0].length || beginColumn == fullBoard[0].length;
    }

    @Override
    Boolean checkPreviousQuadruplet() {
        return fullBoard[beginRow][beginColumn] != fullBoard[beginRow+previousQuadrupletOffset][beginColumn+previousQuadrupletOffset];
    }

    @Override
    Boolean checkNextQuadruplet() {
        return fullBoard[beginRow][beginColumn] != fullBoard[beginRow+nextQuadrupletOffset][beginColumn+nextQuadrupletOffset];
    }
}
