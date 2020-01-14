package winning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerticalQuadruplet extends Quadruplet {

    public VerticalQuadruplet(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        super(beginRow, beginColumn);

        Character[] quadruplet = new Character[]{fullBoard[beginRow][beginColumn], fullBoard[beginRow + 1][beginColumn],
                fullBoard[beginRow + 2][beginColumn], fullBoard[beginRow + 3][beginColumn]};
        this.isQuadrupletValid = Arrays.stream(quadruplet).allMatch(Character.valueOf('B')::equals);

        boolean isQuadrupletAtBeginning;
        boolean isQuadrupletAtEnd;

        if (beginRow == 0) {
            isQuadrupletAtBeginning = true;
            isQuadrupletAtEnd = false;
        } else if (beginRow == fullBoard[0].length - 4) {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = true;
        } else {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = false;
        }

        if (isQuadrupletAtBeginning) {
            isQuadrupletCandidate = quadruplet[0] != fullBoard[beginRow + nextQuadrupletOffset][beginColumn];
        } else if (isQuadrupletAtEnd) {
            isQuadrupletCandidate = quadruplet[0] != fullBoard[beginRow + previousQuadrupletOffset][beginColumn];
        } else {
            isQuadrupletCandidate = quadruplet[0] != fullBoard[beginRow + previousQuadrupletOffset][beginColumn]
                    && quadruplet[0] != fullBoard[beginRow + nextQuadrupletOffset][beginColumn];
        }

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
