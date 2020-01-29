package winning.limits;

public class HorizontalLimits implements Limits {

    private int boardSize;

    public HorizontalLimits(Integer boardSize) {
        
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
        return boardSize-1;
    }
    
    @Override
    public int endColInclusive() {
        return boardSize-QUADRUPLET_SIZE;
    }
}
