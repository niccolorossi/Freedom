package winning;

import game.Board;

public class Points {


    private LiveStonesBoard blackBoard;
    private LiveStonesBoard whiteBoard;
    private Integer boardSize;


    public Points(Board fullBoard) {

        this.boardSize = fullBoard.size();
        this.blackBoard = new LiveStonesBoard(fullBoard, 'B');
        this.whiteBoard = new LiveStonesBoard(fullBoard, 'W');

    }

    public Integer getBlackPoints() {

        blackBoard.aliveStonesForCurrentPlayer();

        Integer count = 0;

        for(int row = 0; row < boardSize; row ++){
            for (int col = 0; col < boardSize; col ++){
                count += blackBoard.getCurrentBoard()[row][col] ? 1 : 0;
            }
        }

        return count;

    }

    public Integer getWhitePoints() {

        whiteBoard.aliveStonesForCurrentPlayer();

        Integer count = 0;

        for(int row = 0; row < boardSize; row ++){
            for (int col = 0; col < boardSize; col ++){
                count += whiteBoard.getCurrentBoard()[row][col] ? 1 : 0;
            }
        }

        return count;
    }
}
