package winningnic;

public class HorizontalQuadruplet extends Quadruplet {

    public HorizontalQuadruplet(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        super(fullBoard, beginRow, beginColumn);
        this.quadruplet = new Character[] {fullBoard[beginRow][beginColumn], fullBoard[beginRow][beginColumn+1],
                                            fullBoard[beginRow][beginColumn+2], fullBoard[beginRow][beginColumn+3]};
    }
    
    @Override
    Boolean quadrupleIsAtBeginning() {
        return beginColumn == 0;
    }

    @Override
    Boolean quadrupleIsAtEnd() {
        return beginColumn.equals(boardSize);
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
