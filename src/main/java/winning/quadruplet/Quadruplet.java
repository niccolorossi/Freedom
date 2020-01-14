package winning.quadruplet;

import java.util.List;

public abstract class Quadruplet {

    
    Integer beginRow;
    Integer beginColumn;
     
    Quadruplet(Integer beginRow, Integer beginColumn) {
        this.beginRow = beginRow;
        this.beginColumn = beginColumn;
    }

    abstract public List<List<Integer>> getIndices();
}
