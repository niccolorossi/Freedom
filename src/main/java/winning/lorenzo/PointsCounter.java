package winning.lorenzo;

import winning.LiveStonesBoard;
import winning.QuadrupletChecker;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class PointsCounter {


    private LiveStonesBoard blackBoard;
    private QuadrupletChecker blackQuadrupletChecker;
    private Integer boardSize;


    public PointsCounter(Character[][] fullBoard) {
        this.blackBoard = new LiveStonesBoard(fullBoard.length);
        this.blackQuadrupletChecker = new  QuadrupletChecker(blackBoard, fullBoard);
        this.boardSize = fullBoard[0].length;

    }

    public Integer getPoints() {

        blackQuadrupletChecker.setAllRowStones();
        blackQuadrupletChecker.setAllColumnStones();
        blackQuadrupletChecker.setAllDiagonalStones();
        blackQuadrupletChecker.setAllAntiDiagonalStones();

        Integer count = IntStream.range(0, boardSize)
                .forEach(r -> IntStream.range(0, boardSize)
                        .forEach(c -> blackBoard[r][c] == true)
                );

    }

    private Predicate<Boolean> isStoneAlive()
    {
        return p -> p  ;
    }


}
