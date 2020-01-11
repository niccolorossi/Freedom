package winningnic;

public class DiagonalQuadruplet extends Quadruplet {
    
    public DiagonalQuadruplet(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        super(fullBoard, beginRow, beginColumn);
        this.quadruplet = new Character[] {fullBoard[beginRow][beginColumn], fullBoard[beginRow+1][beginColumn+1],
                fullBoard[beginRow+2][beginColumn+2], fullBoard[beginRow+3][beginColumn+3]};
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

    @Override
    public void setStones(Boolean[][] board) {
        for(int index = beginColumn; index < beginColumn+4; index++) {
            board[index][index] = true;
        }
    }
    
}
