package winning;

public class PointsCounter {


    private LiveStonesBoard blackBoard;
    private LiveStonesBoard whiteBoard;
    private QuadrupletChecker blackQuadrupletChecker;
    private QuadrupletChecker whiteQuadrupletChecker;
    private Integer boardSize;


    public PointsCounter(Character[][] fullBoard) {
        this.boardSize = fullBoard[0].length;
        this.blackBoard = new LiveStonesBoard(boardSize);
        this.blackQuadrupletChecker = new  QuadrupletChecker(blackBoard, fullBoard, 'B');
        this.whiteBoard = new LiveStonesBoard(boardSize);
        this.whiteQuadrupletChecker = new QuadrupletChecker(whiteBoard, fullBoard, 'W');
    }

    public Integer getBlackPoints() {

        blackQuadrupletChecker.setAllRowStones();
        blackQuadrupletChecker.setAllColumnStones();
        blackQuadrupletChecker.setAllDiagonalStones();
        blackQuadrupletChecker.setAllAntiDiagonalStones();

        Integer count = 0;

        for(int row = 0; row < boardSize; row ++){
            for (int col = 0; col < boardSize; col ++){
                count += blackBoard.getCurrentBoard()[row][col] ? 1 : 0;
            }
        }

        return count;

    }

    public Integer getWhitePoints() {

        whiteQuadrupletChecker.setAllRowStones();
        whiteQuadrupletChecker.setAllColumnStones();
        whiteQuadrupletChecker.setAllDiagonalStones();
        whiteQuadrupletChecker.setAllAntiDiagonalStones();

        Integer count = 0;

        for(int row = 0; row < boardSize; row ++){
            for (int col = 0; col < boardSize; col ++){
                count += whiteBoard.getCurrentBoard()[row][col] ? 1 : 0;
            }
        }

        return count;
    }
}
