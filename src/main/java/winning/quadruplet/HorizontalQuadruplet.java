package winning.quadruplet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HorizontalQuadruplet extends Quadruplet {
    
    public HorizontalQuadruplet(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {

        super(beginRow, beginColumn);

    }

    @Override
    public List<List<Integer>> getIndices() {
        List<List<Integer>> toReturn = new ArrayList<>();
        for(int column = beginColumn; column < beginColumn+4; column++) {
            toReturn.add(Arrays.asList(beginRow, column));
        }
        return toReturn;
    }
}
