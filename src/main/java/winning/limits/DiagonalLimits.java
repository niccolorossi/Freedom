package winning.limits;

public class DiagonalLimits implements Limits {

    private Integer boardSize;

    public DiagonalLimits(Integer boardSize) {
        this.boardSize= boardSize;
    }
    
    @Override
    public int beginRow() {
        return 0;
    }

    @Override
    public int beginCol() {
        return 0;
    }

    @Override
    public int endRowInclusive() {
        return boardSize-QUADRUPLET_SIZE;
    }

    @Override
    public int endColInclusive() {
        return boardSize-QUADRUPLET_SIZE;
    }
}
