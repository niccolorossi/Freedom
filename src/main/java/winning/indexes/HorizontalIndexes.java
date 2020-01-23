package winning.indexes;

import winning.PlayerLiveStonesBoard;

public class HorizontalIndexes extends Indexes {
    
    public HorizontalIndexes(Integer beginRow, Integer beginColumn) {

        super(beginRow, beginColumn);
    }

    @Override
    public void setIndexes(PlayerLiveStonesBoard liveStonesBoard) {
        for(int column = beginColumn; column < beginColumn+4; column++) {
            liveStonesBoard.setLiveStones(beginRow, column);
        }
    }
}
