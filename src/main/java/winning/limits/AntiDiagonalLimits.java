package winning.limits;

public class AntiDiagonalLimits {

    private Integer boardSize;
    public AntiDiagonalLimits(Integer length) {
        this.boardSize = length;
    }

    public Integer beginRowOfLowermostAntiDiagonalQuadruplets() {
        return boardSize - 1;
    }

    public Integer beginColOfLowermostAntiDiagonalQuadruplets(){
        return 0;
    }

    public Integer beginRowOfUppermostAntiDiagonalQuadruplets() {
        return 3;
    }
    public Integer beginColOfUppermostAntiDiagonalQuadruplets() {
        return boardSize - 4;
    }
}
