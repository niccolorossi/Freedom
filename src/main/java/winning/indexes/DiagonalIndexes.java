package winning.indexes;

import winning.LiveStonesBoard;

public class DiagonalIndexes extends Indexes {
    
    public DiagonalIndexes(Integer beginRow, Integer beginColumn) {

        super(beginRow, beginColumn);
    }

    @Override
    public void setIndexes(LiveStonesBoard liveStonesBoard) {
        for (int index = 0; index < 4; index++) {
            liveStonesBoard.placeLiveStones(beginRow+index, beginColumn+index);
        }
    }
}
