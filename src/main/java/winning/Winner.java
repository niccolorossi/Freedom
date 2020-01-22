package winning;

import game.Board;

import java.util.Arrays;
import java.util.List;

public class Winner {

    private Points pc;

    public Winner(Board fullBoard) {

        this.pc = new Points(fullBoard);
    }

    public List<Integer> getWinner() {

        Integer whitePoints = pc.getWhitePoints();
        Integer blackPoints = pc.getBlackPoints();

        return Arrays.asList(whitePoints, blackPoints);

    }
}
