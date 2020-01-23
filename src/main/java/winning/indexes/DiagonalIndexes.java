package winning.indexes;

import winning.PlayerLiveStonesBoard;

public class DiagonalIndexes extends Indexes {
    
    public DiagonalIndexes(Integer beginRow, Integer beginColumn) {

        super(beginRow, beginColumn);
    }

    @Override
    public void setIndexes(PlayerLiveStonesBoard liveStonesBoard) {
        for (int index = 0; index < 4; index++) {
            liveStonesBoard.setLiveStones(beginRow+index, beginColumn+index);
        }
    }
}
