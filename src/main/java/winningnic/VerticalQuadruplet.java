package winningnic;

public class VerticalQuadruplet extends Quadruplet {

    public VerticalQuadruplet(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        super(fullBoard, beginRow, beginColumn);
    }
    
    @Override
    Boolean quadrupleIsAtBeginning() {
        return beginRow == 0;
    }
    
    @Override 
    Boolean quadrupleIsAtEnd() {
        return beginRow == fullBoard[0].length;
    }

    @Override
    Boolean checkPreviousQuadruplet() {
        return fullBoard[beginRow][beginColumn] != fullBoard[beginRow+previousQuadrupletOffset][beginColumn];
    }

    @Override
    Boolean checkNextQuadruplet() {
        return fullBoard[beginRow][beginColumn] != fullBoard[beginRow+nextQuadrupletOffset][beginColumn];
    }
}
