package winningnic;

public class VerticalQuadruplet extends Quadruplet {

    public VerticalQuadruplet(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        super(fullBoard, beginRow, beginColumn);
        this.quadruplet = new Character[] {fullBoard[beginRow][beginColumn], fullBoard[beginRow+1][beginColumn],
                fullBoard[beginRow+2][beginColumn], fullBoard[beginRow+3][beginColumn]};

        if(beginRow == 0) {
            this.isQuadrupletAtBeginning = true;
            this.isQuadrupletAtEnd = false;
        } else if(beginRow == boardSize-quadruplet.length) {
            this.isQuadrupletAtBeginning = false;
            this.isQuadrupletAtEnd = true;
        } else {
            this.isQuadrupletAtBeginning = false;
            this.isQuadrupletAtEnd = false;
        }

        if(!isQuadrupletAtBeginning) {
            this.previousElement = fullBoard[beginRow+previousQuadrupletOffset][beginColumn];
        }
        if(!isQuadrupletAtEnd) {
            this.nextElement = fullBoard[beginRow+nextQuadrupletOffset][beginColumn];
        }
    }
    
    @Override
    public void setStones(Boolean[][] board) {
        for(int row = beginRow; row < beginRow+4; row++) {
            board[row][beginColumn] = true;
        }
    }

}
