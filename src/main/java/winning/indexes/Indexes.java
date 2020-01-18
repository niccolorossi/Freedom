package winning.indexes;

import java.util.List;

public abstract class Indexes {
    
    Integer beginRow;
    Integer beginColumn;
     
    Indexes(Integer beginRow, Integer beginColumn) {
        this.beginRow = beginRow;
        this.beginColumn = beginColumn;
    }

    abstract public List<List<Integer>> getIndexes();
}
