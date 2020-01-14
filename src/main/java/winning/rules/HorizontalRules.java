package winning.rules;

import java.util.Arrays;
import java.util.stream.IntStream;

public class HorizontalRules implements ValidRule, CandidateRule {
    
    @Override
    public Boolean isValid(Character[][] fullBoard, Integer beginRow, Integer beginColumn, Character currentStone) {
        
        return IntStream.range(0, quadrupletSize).mapToObj(i -> fullBoard[beginRow][beginColumn+i])
                .allMatch(Character.valueOf(currentStone)::equals);
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
