package winning.limits;

public class HorizontalLimits {

    private Integer boardSize;

    public HorizontalLimits(Integer length) {
        this.boardSize = length;
    }

    public Integer beginColOfLeftmostHorizontalQuadruplets(){
        return 0;
    }

    public Integer beginColOfRightmostHorizontalQuadruplets(){
        return boardSize - 4;
    }


}
