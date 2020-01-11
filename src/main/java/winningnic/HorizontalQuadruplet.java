package winningnic;

public class HorizontalQuadruplet extends Quadruplet {

    public HorizontalQuadruplet(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        super(fullBoard, beginRow, beginColumn);
    }
    
    @Override
    Boolean quadrupleIsAtBeginning() {
        return beginColumn == 0;
    }

    @Override
    Boolean quadrupleIsAtEnd() {
        return beginColumn == fullBoard[0].length;
    }
    
    @Override
    Boolean checkPreviousQuadruplet() {
        return fullBoard[beginRow][beginColumn] != fullBoard[beginRow][beginColumn+previousQuadrupletOffset];
    }
    
    @Override
    Boolean checkNextQuadruplet() {
        return fullBoard[beginRow][beginColumn] != fullBoard[beginRow][beginColumn+nextQuadrupletOffset];
    }
}
