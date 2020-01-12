package winningnic;

public class AntiDiagonalQuadruplet extends Quadruplet {
    
    public AntiDiagonalQuadruplet(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        super(beginRow, beginColumn);
        this.quadruplet = new Character[] {fullBoard[beginRow][beginColumn], fullBoard[beginRow-1][beginColumn+1],
                fullBoard[beginRow-2][beginColumn+2], fullBoard[beginRow-3][beginColumn+3]};

        if(beginColumn == 0 && beginRow != 4 || beginRow == 9 && beginColumn != 6) {
            this.isQuadrupletAtBeginning = true;
            this.isQuadrupletAtEnd = false;
        } else if(beginColumn == 6 && beginRow != 4 || beginRow == 4 && beginColumn != 6) {
            this.isQuadrupletAtBeginning = false;
            this.isQuadrupletAtEnd = true;
        } else if((beginRow == 4 && beginColumn == 0) || (beginRow == 9 && beginColumn == 6)) {
            this.isQuadrupletAtBeginning = true;
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
