package winningnic;

public class VerticalQuadruplet extends Quadruplet {

    public VerticalQuadruplet(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        super(fullBoard, beginRow, beginColumn);
        this.quadruplet = new Character[] {fullBoard[beginRow][beginColumn], fullBoard[beginRow+1][beginColumn],
                fullBoard[beginRow+2][beginColumn], fullBoard[beginRow+3][beginColumn]};
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
