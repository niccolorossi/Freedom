package winning.indexes;

import winning.LiveStonesBoard;

public abstract class Indexes {
    
    Integer beginRow;
    Integer beginColumn;
     
    Indexes(Integer beginRow, Integer beginColumn) {
        this.beginRow = beginRow;
        this.beginColumn = beginColumn;
    }

    abstract public void setIndexes(LiveStonesBoard liveStonesBoard);
}
