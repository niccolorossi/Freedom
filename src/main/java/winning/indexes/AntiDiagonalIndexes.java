package winning.indexes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AntiDiagonalIndexes extends Indexes {
    
    public AntiDiagonalIndexes(Integer beginRow, Integer beginColumn) {
        super(beginRow, beginColumn);
    }
    
    @Override
    public List<List<Integer>> getIndexes() {
        List<List<Integer>> toReturn = new ArrayList<>();
        for (int index = 0; index < 4; index++) {
            toReturn.add(Arrays.asList(beginRow-index, beginColumn+index));
        }
        return toReturn;
    }

}
