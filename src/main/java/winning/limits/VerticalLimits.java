package winning.limits;

public class VerticalLimits implements Limits {
    
    private Integer boardSize;

    public VerticalLimits(Integer boardSize) {
        this.boardSize = boardSize;
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
        return boardSize-1;
    }
}
