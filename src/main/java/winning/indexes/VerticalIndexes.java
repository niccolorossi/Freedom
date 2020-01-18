package winning.indexes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerticalIndexes extends Indexes {

    public VerticalIndexes(Integer beginRow, Integer beginColumn) {

        super(beginRow, beginColumn);

    }

    @Override
    public List<List<Integer>> getIndexes() {
        List<List<Integer>> toReturn = new ArrayList<>();
        for (int row = beginRow; row < beginRow + 4; row++) {
            toReturn.add(Arrays.asList(row, beginColumn));
        }
        return toReturn;
    }
}
