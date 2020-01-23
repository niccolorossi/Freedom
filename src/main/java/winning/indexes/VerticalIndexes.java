package winning.indexes;

import winning.PlayerLiveStonesBoard;

public class VerticalIndexes extends Indexes {

    public VerticalIndexes(Integer beginRow, Integer beginColumn) {

        super(beginRow, beginColumn);
    }

    @Override
    public void setIndexes(PlayerLiveStonesBoard liveStonesBoard) {
        for(int row = beginRow; row < beginRow+4; row++) {
            liveStonesBoard.setLiveStones(row, beginColumn);
        }
    }
}
