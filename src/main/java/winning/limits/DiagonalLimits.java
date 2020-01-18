package winning.limits;
import winning.rules.Rules;

public class DiagonalLimits {

    private Integer boardSize;

    public DiagonalLimits(Integer boardSize) {
        this.boardSize= boardSize;
    }


    public Integer beginRowOfUppermostDiagonalQuadruplets() {
        return 0;
    }

    public Integer beginColOfUppermostDiagonalQuadruplets() {
        return 0;
    }

    public Integer beginRowOfLowermostDiagonalQuadruplets() {
        return boardSize - Rules.QUADRUPLET_SIZE;
    }
    public Integer beginColOfLowermostDiagonalQuadruplets() {
        return boardSize - Rules.QUADRUPLET_SIZE;
    };
}
