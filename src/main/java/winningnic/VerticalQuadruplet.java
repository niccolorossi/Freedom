package winningnic;

public class VerticalQuadruplet extends Quadruplet {

    public VerticalQuadruplet(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        super(fullBoard, beginRow, beginColumn);
        this.quadruplet = new Character[] {fullBoard[beginRow][beginColumn], fullBoard[beginRow+1][beginColumn],
                fullBoard[beginRow+2][beginColumn], fullBoard[beginRow+3][beginColumn]};
        if(beginRow != 0) {
            this.previousElement = fullBoard[beginRow+previousQuadrupletOffset][beginColumn];
        }
        if(beginRow != boardSize-4) {
            this.nextElement = fullBoard[beginRow+nextQuadrupletOffset][beginColumn];
        }
    }

    @Override
    Boolean quadrupleIsAtBeginning() {
        return beginRow == 0;
    }

    @Override
    Boolean quadrupleIsAtEnd() {
        return beginRow == boardSize;
    }
    
    @Override
    public void setStones(Boolean[][] board) {
        for(int row = beginRow; row < beginRow+4; row++) {
            board[row][beginColumn] = true;
        }
    }

}
