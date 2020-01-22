package winning;

import game.Board;

public class Points {


    private LiveStonesBoard blackBoard;
    private LiveStonesBoard whiteBoard;

    public Points(Board fullBoard) {

        this.blackBoard = new LiveStonesBoard(fullBoard, 'B');
        this.whiteBoard = new LiveStonesBoard(fullBoard, 'W');

    }

    public Integer getBlackPoints() {

        blackBoard.aliveStonesForCurrentPlayer();
        return countStonesAlive(blackBoard);
    }

    public Integer getWhitePoints() {

        whiteBoard.aliveStonesForCurrentPlayer();
        return countStonesAlive(whiteBoard);
    }

    private Integer countStonesAlive(LiveStonesBoard board) {

        int boardSize = board.size();
        int count = 0;

        for(int row = 0; row < boardSize; row ++){
            for (int col = 0; col < boardSize; col ++){
                count += board.getCurrentBoard()[row][col] ? 1 : 0;
            }
        }
        return count;
    }
}
