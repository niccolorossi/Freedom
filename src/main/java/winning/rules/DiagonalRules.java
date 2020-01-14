package winning.rules;

import java.util.stream.IntStream;

public class DiagonalRules implements ValidRule, CandidateRule {

    @Override
    public Boolean isValid(Character[][] fullBoard, Integer beginRow, Integer beginColumn, Character currentStone) {

        return IntStream.range(0, quadrupletSize).mapToObj(i -> fullBoard[beginRow+i][beginColumn+i])
                .allMatch(Character.valueOf(currentStone)::equals);
    }


    @Override
    public Boolean isCandidate(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {

        boolean isQuadrupletAtBeginning;
        boolean isQuadrupletAtEnd;

        if(beginColumn == 0 && beginRow != 6 || beginRow == 0 && beginColumn != 6) {
            isQuadrupletAtBeginning = true;
            isQuadrupletAtEnd = false;
        } else if(beginColumn == 6 && beginRow != 0 || beginRow == 6 && beginColumn != 0) {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = true;
        } else if((beginRow == 0 && beginColumn == 6) || (beginRow == 6 && beginColumn == 0)) {
            isQuadrupletAtBeginning = true;
            isQuadrupletAtEnd = true;
        } else {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = false;
        }

        Character currentElement = fullBoard[beginRow][beginColumn];

        if(isQuadrupletAtBeginning && !isQuadrupletAtEnd) {
            return currentElement != fullBoard[beginRow + quadrupletSize][beginColumn + quadrupletSize];
        } else if(isQuadrupletAtEnd && !isQuadrupletAtBeginning) {
            return currentElement != fullBoard[beginRow + previousQuadrupletOffset][beginColumn+previousQuadrupletOffset];
        } else if(!isQuadrupletAtBeginning && !isQuadrupletAtEnd) {
            return currentElement != fullBoard[beginRow + previousQuadrupletOffset][beginColumn + previousQuadrupletOffset]
                    && currentElement != fullBoard[beginRow + quadrupletSize][beginColumn + quadrupletSize];
        } else return true;
    }
}
