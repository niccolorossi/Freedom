package winning;

import java.util.Arrays;
import java.util.stream.IntStream;

public class VerticalRules implements ValidRule , CandidateRule {

    @Override
    public Boolean isValid(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {

        Character[] quadrupletArray = new Character[quadrupletSize];

        IntStream.range(0, quadrupletSize)
                .forEach(r -> quadrupletArray[r] = fullBoard[beginRow + r][beginColumn]);

        return Arrays.stream(quadrupletArray).allMatch(Character.valueOf('B')::equals);
    }

    @Override
    public Boolean isCandidate(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        boolean isQuadrupletAtBeginning;
        boolean isQuadrupletAtEnd;
        Integer boardSize = fullBoard[0].length;

        if (beginRow == firstIndex) {
            isQuadrupletAtBeginning = true;
            isQuadrupletAtEnd = false;
        } else if (beginRow == boardSize - 4) {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = true;
        } else {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = false;
        }

        Character currentElement = fullBoard[beginRow][beginColumn];

        if (isQuadrupletAtBeginning) {
            return currentElement != fullBoard[beginRow + quadrupletSize][beginColumn];
        } else if (isQuadrupletAtEnd) {
           return currentElement != fullBoard[beginRow + previousQuadrupletOffset][beginColumn];
        } else {
            return currentElement != fullBoard[beginRow + previousQuadrupletOffset][beginColumn]
                    && currentElement != fullBoard[beginRow + quadrupletSize][beginColumn];
        }
    }
}
