package winning.limits;

public class AntiDiagonalLimits implements Limits {
    
    private Integer boardSize;
    
    public AntiDiagonalLimits(Integer length) {
        this.boardSize = length;
    }

    @Override
    public int beginRow() {
        return boardSize-1;
    }

    @Override
    public int beginCol() {
        return 0;
    }

    @Override
    public int endRowInclusive() {
        return QUADRUPLET_SIZE-1;
    }

    @Override
    public int endColInclusive() {
        return boardSize-QUADRUPLET_SIZE;
    }
}
