package winning.rules;

import java.util.stream.IntStream;

public class HorizontalRules implements Rules {
    
    @Override
    public Boolean isValid(Character[][] fullBoard, Integer beginRow, Integer beginColumn, Character currentStone) {
        
        return IntStream.range(0, QUADRUPLET_SIZE).mapToObj(i -> fullBoard[beginRow][beginColumn+i])
                .allMatch(currentStone::equals);
    }

    @Override
    public Boolean isCandidate(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {

        int boardSize = fullBoard[0].length;
        boolean isQuadrupletAtBeginning;
        boolean isQuadrupletAtEnd;

        if(beginColumn.equals(FIRST_INDEX)) {
            isQuadrupletAtBeginning = true;
            isQuadrupletAtEnd = false;
        } else if(beginColumn == boardSize - QUADRUPLET_SIZE) {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = true;
        } else {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = false;
        }

        Character currentElement = fullBoard[beginRow][beginColumn];

        if(isQuadrupletAtBeginning) {
            return currentElement != fullBoard[beginRow][beginColumn + QUADRUPLET_SIZE];
        } else if(isQuadrupletAtEnd) {
            return currentElement != fullBoard[beginRow][beginColumn + PREVIOUS_QUADRUPLET_OFFSET];
        } else {
            return currentElement != fullBoard[beginRow][beginColumn + PREVIOUS_QUADRUPLET_OFFSET]
                    && currentElement != fullBoard[beginRow][beginColumn + QUADRUPLET_SIZE];
        }
    }
}
