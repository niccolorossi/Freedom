package winning;

public class QuadrupletChecker {
    
    private LiveStonesBoard liveStonesBoard;
    private Character[][] fullBoard;
    private Integer boardSize;
    private HorizontalRules hr;
    private VerticalRules vvr;
    private DiagonalRules dvr;
    private AntiDiagonalRules advr;
    
    public QuadrupletChecker(LiveStonesBoard liveStonesBoard, Character[][] fullBoard) {
        this.liveStonesBoard = liveStonesBoard;
        this.fullBoard = fullBoard;
        this.boardSize = liveStonesBoard.getCurrentBoard().length;
        this.hr = new HorizontalRules();
        this.vvr = new VerticalRules();
        this.dvr = new DiagonalRules();
        this.advr = new AntiDiagonalRules();
    }

    public void setAllRowStones() {
        for(int row=0; row<boardSize; row++) {
            for(int col=0; col<=6; col++) {
                HorizontalQuadruplet horizontalQuadruplet = new HorizontalQuadruplet(fullBoard,row,col);
                if(hr.isValid(fullBoard, row, col) && hr.isCandidate(fullBoard, row, col)) {
                    liveStonesBoard.setStones(horizontalQuadruplet);
                }
            }
           
        }
    }
    
    public void setAllColumnStones() {
        for(int col=0; col<boardSize; col++) {
            for(int row=0; row<=6; row++) {
                VerticalQuadruplet verticalQuadruplet = new VerticalQuadruplet(fullBoard,row,col);
                if(vvr.isValid(fullBoard, row, col) && vvr.isCandidate(fullBoard, row, col)) {
                    liveStonesBoard.setStones(verticalQuadruplet);
                }
            }

        }
    }

    public void setAllDiagonalStones() {
        for(int row=0; row<=6; row++) {
            for(int col=0; col<=6; col++) {
                DiagonalQuadruplet diagonalQuadruplet = new DiagonalQuadruplet(fullBoard,row,col);
                if(dvr.isValid(fullBoard, row, col) && dvr.isCandidate(fullBoard, row, col)) {
                    liveStonesBoard.setStones(diagonalQuadruplet);
                }
            }
        }
    }

    public void setAllAntiDiagonalStones() {
        for(int row=9; row>=3; row--) {
            for(int col=0; col<=6; col++) {
                AntiDiagonalQuadruplet antiDiagonalQuadruplet = new AntiDiagonalQuadruplet(fullBoard,row,col);
                if(advr.isValid(fullBoard, row, col) && advr.isCandidate(fullBoard, row, col)) {
                    liveStonesBoard.setStones(antiDiagonalQuadruplet);
                }
            }

        }
    }
}
