package winning.limits;

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
        return boardSize - 4;
    }
    public Integer beginColOfLowermostDiagonalQuadruplets() {
        return boardSize - 4;
    };
}
