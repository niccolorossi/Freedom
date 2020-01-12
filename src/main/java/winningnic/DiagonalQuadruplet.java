package winningnic;

public class DiagonalQuadruplet extends Quadruplet {
    
    public DiagonalQuadruplet(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        super(fullBoard, beginRow, beginColumn);
        this.quadruplet = new Character[] {fullBoard[beginRow][beginColumn], fullBoard[beginRow+1][beginColumn+1],
                fullBoard[beginRow+2][beginColumn+2], fullBoard[beginRow+3][beginColumn+3]};
        
        if(beginColumn == 0 || beginRow == 0) {
            this.isQuadrupletAtBeginning = true;
            this.isQuadrupletAtEnd = false;
        } else if(beginColumn == boardSize-quadruplet.length || beginColumn == boardSize-quadruplet.length) {
            this.isQuadrupletAtBeginning = false;
            this.isQuadrupletAtEnd = true;
        } else {
            this.isQuadrupletAtBeginning = false;
            this.isQuadrupletAtEnd = false;
        }

        if(!isQuadrupletAtBeginning) {
            this.previousElement = fullBoard[beginRow+previousQuadrupletOffset][beginColumn+previousQuadrupletOffset];
        }
        if(!isQuadrupletAtEnd) {
            this.nextElement = fullBoard[beginRow+nextQuadrupletOffset][beginColumn+nextQuadrupletOffset];
        }
    }

    @Override
    public void setStones(Boolean[][] board) {
        for(int index = beginColumn; index < beginColumn+4; index++) {
            board[index][index] = true;
        }
    }
    
}
