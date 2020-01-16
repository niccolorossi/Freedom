package winning.indeces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerticalIndeces extends Indeces {

    public VerticalIndeces(Integer beginRow, Integer beginColumn) {

        super(beginRow, beginColumn);

    }

    @Override
    public List<List<Integer>> getIndices() {
        List<List<Integer>> toReturn = new ArrayList<>();
        for (int row = beginRow; row < beginRow + 4; row++) {
            toReturn.add(Arrays.asList(row, beginColumn));
        }
        return toReturn;
    }
}
