package winning;

public class Points {


    private LiveStonesBoard blackBoard;
    private LiveStonesBoard whiteBoard;
    private PlayerQuadruplets blackPlayerQuadruplets;
    private PlayerQuadruplets whitePlayerQuadruplets;
    private Integer boardSize;


    public Points(Character[][] fullBoard) {
        this.boardSize = fullBoard[0].length;

        this.blackBoard = new LiveStonesBoard(boardSize);
        this.blackPlayerQuadruplets = new PlayerQuadruplets(blackBoard, fullBoard, 'B');

        this.whiteBoard = new LiveStonesBoard(boardSize);
        this.whitePlayerQuadruplets = new PlayerQuadruplets(whiteBoard, fullBoard, 'W');
    }

    public Integer getBlackPoints() {

        blackPlayerQuadruplets.findHorizontalQuadruplets();
        blackPlayerQuadruplets.findVerticalQuadruplets();
        blackPlayerQuadruplets.findDiagonalQuadruplets();
        blackPlayerQuadruplets.findAntiDiagonalQuadruplets();

        Integer count = 0;

        for(int row = 0; row < boardSize; row ++){
            for (int col = 0; col < boardSize; col ++){
                count += blackBoard.getCurrentBoard()[row][col] ? 1 : 0;
            }
        }

        return count;

    }

    public Integer getWhitePoints() {

        whitePlayerQuadruplets.findHorizontalQuadruplets();
        whitePlayerQuadruplets.findVerticalQuadruplets();
        whitePlayerQuadruplets.findDiagonalQuadruplets();
        whitePlayerQuadruplets.findAntiDiagonalQuadruplets();

        Integer count = 0;

        for(int row = 0; row < boardSize; row ++){
            for (int col = 0; col < boardSize; col ++){
                count += whiteBoard.getCurrentBoard()[row][col] ? 1 : 0;
            }
        }

        return count;
    }
}
