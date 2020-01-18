package winning.limits;
import winning.rules.Rules;


public class VerticalLimits {
    private Integer boardSize;

    public VerticalLimits(Integer boardSize) {
        this.boardSize = boardSize;
    }



    public Integer beginRowOfUppermostVerticalQuadruplets(){
        return 0;
    }

    public Integer beginRowOfLowermostVerticalQuadruplets() {
        return boardSize - Rules.QUADRUPLET_SIZE;
    }
}
