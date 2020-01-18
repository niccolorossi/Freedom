package winning.indexes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HorizontalIndexes extends Indexes {
    
    public HorizontalIndexes(Integer beginRow, Integer beginColumn) {

        super(beginRow, beginColumn);

    }

    @Override
    public List<List<Integer>> getIndexes() {
        List<List<Integer>> toReturn = new ArrayList<>();
        for(int column = beginColumn; column < beginColumn+4; column++) {
            toReturn.add(Arrays.asList(beginRow, column));
        }
        return toReturn;
    }
}
