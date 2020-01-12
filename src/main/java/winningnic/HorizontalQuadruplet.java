package winningnic;

public class HorizontalQuadruplet extends Quadruplet {

    public HorizontalQuadruplet(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        super(fullBoard, beginRow, beginColumn);
        this.quadruplet = new Character[] {fullBoard[beginRow][beginColumn], fullBoard[beginRow][beginColumn+1],
                                            fullBoard[beginRow][beginColumn+2], fullBoard[beginRow][beginColumn+3]};
        if(beginColumn != 0) {
            this.previousElement = fullBoard[beginRow][beginColumn+previousQuadrupletOffset];
        }
        if(beginColumn != boardSize-4) {
            this.nextElement = fullBoard[beginRow][beginColumn+nextQuadrupletOffset];
        }
    }

    @Override
    Boolean quadrupleIsAtBeginning() {
        return beginColumn == 0;
    }

    @Override
    Boolean quadrupleIsAtEnd() {
        return beginColumn == boardSize-4;
    }

    @Override
    public void setStones(Boolean[][] board) {
        for(int column = beginColumn; column < beginColumn+4; column++) {
            board[beginRow][column] = true;
        }
    }
}
