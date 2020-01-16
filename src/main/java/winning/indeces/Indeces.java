package winning.indeces;

import java.util.List;

public abstract class Indeces {
    
    Integer beginRow;
    Integer beginColumn;
     
    Indeces(Integer beginRow, Integer beginColumn) {
        this.beginRow = beginRow;
        this.beginColumn = beginColumn;
    }

    abstract public List<List<Integer>> getIndices();
}
