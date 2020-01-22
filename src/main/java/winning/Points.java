package winning;

import game.Board;

public class Points {


    private PlayerQuadruplets blackQuadruplets;
    private PlayerQuadruplets whiteQuadruplets;

    public Points(Board fullBoard) {

        this.blackQuadruplets = new PlayerQuadruplets(fullBoard, 'B');
        this.whiteQuadruplets = new PlayerQuadruplets(fullBoard, 'W');
    }

    public Integer getBlackPoints() {
        return blackQuadruplets.countLiveStones();
    }

    public Integer getWhitePoints() {
        return whiteQuadruplets.countLiveStones();
    }
}
