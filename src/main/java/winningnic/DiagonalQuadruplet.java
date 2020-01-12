package winningnic;

public class DiagonalQuadruplet extends Quadruplet {
    
    public DiagonalQuadruplet(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        super(fullBoard, beginRow, beginColumn);
        this.quadruplet = new Character[] {fullBoard[beginRow][beginColumn], fullBoard[beginRow+1][beginColumn+1],
                fullBoard[beginRow+2][beginColumn+2], fullBoard[beginRow+3][beginColumn+3]};
        if(beginColumn != 0 && beginRow != 0) {
            this.previousElement = fullBoard[beginRow+previousQuadrupletOffset][beginColumn+previousQuadrupletOffset];
        }
        if(beginColumn != boardSize-4 && beginColumn != boardSize-4) {
            this.nextElement = fullBoard[beginRow+nextQuadrupletOffset][beginColumn+nextQuadrupletOffset];
        }
    }

    @Override
    Boolean quadrupleIsAtBeginning() {
        return beginRow == 0 || beginColumn == 0;
    }

    @Override
    Boolean quadrupleIsAtEnd() {
        return beginRow == boardSize-4 || beginColumn == boardSize-4;
    }

    @Override
    public void setStones(Boolean[][] board) {
        for(int index = beginColumn; index < beginColumn+4; index++) {
            board[index][index] = true;
        }
    }
    
}
