package winningnic;

public class QuadrupletChecker {
    
    private LiveStonesBoard liveStonesBoard;
    private Character[][] fullBoard;
    private Integer boardSize;
    
    public QuadrupletChecker(LiveStonesBoard liveStonesBoard, Character[][] fullBoard) {
        this.liveStonesBoard = liveStonesBoard;
        this.fullBoard = fullBoard;
        this.boardSize = liveStonesBoard.getCurrentBoard().length;
    }

    public void setStones() {
        for(int row=0; row<boardSize; row++) {
            HorizontalQuadruplet horizontalQuadruplet = new HorizontalQuadruplet(fullBoard, row,0);
            if(horizontalQuadruplet.isQuadrupletValid('B')) {
                liveStonesBoard.setStones(horizontalQuadruplet);

            }
        }
    }

    public void setAllRowStones() {
        for(int row=0; row<boardSize; row++) {
            for(int col=0; col<=6; col++) {
                HorizontalQuadruplet horizontalQuadruplet = new HorizontalQuadruplet(fullBoard,row,col);
                if(horizontalQuadruplet.isQuadrupletValid('B')) {
                    liveStonesBoard.setStones(horizontalQuadruplet);
                }
            }
           
        }
    }
    
    public void setAllColumnStones() {
        for(int col=0; col<boardSize; col++) {
            for(int row=0; row<=6; row++) {
                VerticalQuadruplet verticalQuadruplet = new VerticalQuadruplet(fullBoard,row,col);
                if(verticalQuadruplet.isQuadrupletValid('B')) {
                    liveStonesBoard.setStones(verticalQuadruplet);
                }
            }

        }
    }

    public void setAllDiagonalStones() {
        for(int col=0; col<boardSize; col++) {
            for(int row=0; row<=6; row++) {
                VerticalQuadruplet verticalQuadruplet = new VerticalQuadruplet(fullBoard,row,col);
                if(verticalQuadruplet.isQuadrupletValid('B')) {
                    liveStonesBoard.setStones(verticalQuadruplet);
                }
            }

        }
    }
}
