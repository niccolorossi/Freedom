package winning.limits;
import winning.rules.Rules;


public class HorizontalLimits {

    private Integer boardSize;

    public HorizontalLimits(Integer length) {
        this.boardSize = length;
    }

    public Integer beginColOfLeftmostHorizontalQuadruplets(){
        return 0;
    }

    public Integer beginColOfRightmostHorizontalQuadruplets(){
        return boardSize - Rules.QUADRUPLET_SIZE;
    }


}
