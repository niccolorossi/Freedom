package winning.indexes;

import winning.LiveStonesBoard;

public class HorizontalIndexes extends Indexes {
    
    public HorizontalIndexes(Integer beginRow, Integer beginColumn) {

        super(beginRow, beginColumn);
    }

    @Override
    public void setIndexes(LiveStonesBoard liveStonesBoard) {
        for(int column = beginColumn; column < beginColumn+4; column++) {
            liveStonesBoard.setLiveStone(beginRow, column);
        }
    }
}
