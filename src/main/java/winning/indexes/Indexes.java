package winning.indexes;

import winning.PlayerLiveStonesBoard;

public abstract class Indexes {
    
    Integer beginRow;
    Integer beginColumn;
     
    Indexes(Integer beginRow, Integer beginColumn) {
        this.beginRow = beginRow;
        this.beginColumn = beginColumn;
    }

    abstract public void setIndexes(PlayerLiveStonesBoard liveStonesBoard);
}
