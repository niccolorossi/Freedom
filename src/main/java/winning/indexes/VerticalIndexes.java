package winning.indexes;

import winning.LiveStonesBoard;

public class VerticalIndexes extends Indexes {

    public VerticalIndexes(Integer beginRow, Integer beginColumn) {
        super(beginRow, beginColumn);
    }

    @Override
    public void setLiveStonesForThisIndexes(LiveStonesBoard liveStonesBoard) {
        for(int row = beginRow; row < beginRow+4; row++) {
            liveStonesBoard.setLiveStone(row, beginColumn);
        }
    }
}
