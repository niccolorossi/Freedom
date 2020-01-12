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
}
