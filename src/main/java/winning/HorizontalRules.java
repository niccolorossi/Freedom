package winning;

import java.util.Arrays;
import java.util.stream.IntStream;

class HorizontalRules implements ValidRule, CandidateRule {



    @Override
    public Boolean isValid(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {

        Character[] quadrupletArray = new Character[quadrupletSize];

        IntStream.range(0, quadrupletSize)
                .forEach(c -> quadrupletArray[c] = fullBoard[beginRow][beginColumn + c]);

        return Arrays.stream(quadrupletArray).allMatch(Character.valueOf('B')::equals);
    }

    @Override
    public Boolean isCandidate(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {

        Integer boardSize = fullBoard[0].length;
        Boolean isQuadrupletAtBeginning;
        Boolean isQuadrupletAtEnd;

        if(beginColumn == firstIndex) {
            isQuadrupletAtBeginning = true;
            isQuadrupletAtEnd = false;
        } else if(beginColumn == boardSize - quadrupletSize) {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = true;
        } else {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = false;
        }

        Character currentElement = fullBoard[beginRow][beginColumn];

        if(isQuadrupletAtBeginning) {
            return currentElement != fullBoard[beginRow][beginColumn + quadrupletSize];
        } else if(isQuadrupletAtEnd) {
            return currentElement != fullBoard[beginRow][beginColumn + previousQuadrupletOffset];
        } else {
            return currentElement != fullBoard[beginRow][beginColumn + previousQuadrupletOffset]
                    && currentElement != fullBoard[beginRow][beginColumn + quadrupletSize];
        }
    }
}
