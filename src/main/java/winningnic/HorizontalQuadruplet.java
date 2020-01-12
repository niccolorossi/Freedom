package winningnic;

public class HorizontalQuadruplet extends Quadruplet {
    
    public HorizontalQuadruplet(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        super(beginRow, beginColumn);
        this.quadruplet = new Character[] {fullBoard[beginRow][beginColumn], fullBoard[beginRow][beginColumn+1],
                                            fullBoard[beginRow][beginColumn+2], fullBoard[beginRow][beginColumn+3]};
        
        if(beginColumn == 0) {
            this.isQuadrupletAtBeginning = true;
            this.isQuadrupletAtEnd = false;
        } else if(beginColumn == fullBoard[0].length-quadruplet.length) {
            this.isQuadrupletAtBeginning = false;
            this.isQuadrupletAtEnd = true;
        } else {
            this.isQuadrupletAtBeginning = false;
            this.isQuadrupletAtEnd = false;
        }
        
        if(!isQuadrupletAtBeginning) {
            this.previousElement = fullBoard[beginRow][beginColumn+previousQuadrupletOffset];
        }
        if(!isQuadrupletAtEnd) {
            this.nextElement = fullBoard[beginRow][beginColumn+nextQuadrupletOffset];
        }
    }

    @Override
    public void setStones(Boolean[][] board) {
        for(int column = beginColumn; column < beginColumn+4; column++) {
            board[beginRow][column] = true;
        }
    }
}
