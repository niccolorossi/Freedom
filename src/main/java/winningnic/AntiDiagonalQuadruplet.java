package winningnic;

public class AntiDiagonalQuadruplet extends Quadruplet {
    
    public AntiDiagonalQuadruplet(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        super(beginRow, beginColumn);
        this.quadruplet = new Character[] {fullBoard[beginRow][beginColumn], fullBoard[beginRow-1][beginColumn+1],
                fullBoard[beginRow-2][beginColumn+2], fullBoard[beginRow-3][beginColumn+3]};

        if(beginColumn == 0 || beginRow == fullBoard[0].length) {
            this.isQuadrupletAtBeginning = true;
            this.isQuadrupletAtEnd = false;
        } else if(beginColumn == fullBoard[0].length-quadruplet.length || beginRow == fullBoard[0].length-quadruplet.length) {
            this.isQuadrupletAtBeginning = false;
            this.isQuadrupletAtEnd = true;
        } else {
            this.isQuadrupletAtBeginning = false;
            this.isQuadrupletAtEnd = false;
        }

        if(!isQuadrupletAtBeginning) {
            this.previousElement = fullBoard[beginRow+previousQuadrupletOffset][beginColumn-previousQuadrupletOffset];
        }
        if(!isQuadrupletAtEnd) {
            this.nextElement = fullBoard[beginRow+nextQuadrupletOffset][beginColumn-nextQuadrupletOffset];
        }
    }

    @Override
    public void setStones(Boolean[][] board) {
        for(int index = 0; index < 4; index++) {
            board[beginRow-index][beginColumn+index] = true;
        }
    }
    
}
