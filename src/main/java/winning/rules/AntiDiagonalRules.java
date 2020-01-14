package winning.rules;

import java.util.stream.IntStream;

public class AntiDiagonalRules implements Rules {

    @Override
    public Boolean isValid(Character[][] fullBoard, Integer beginRow, Integer beginColumn, Character currentStone) {

        return IntStream.range(0, QUADRUPLET_SIZE).mapToObj(i -> fullBoard[beginRow-i][beginColumn+i])
                .allMatch(Character.valueOf(currentStone)::equals);
    }

    @Override
    public Boolean isCandidate(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        boolean isQuadrupletAtBeginning;
        boolean isQuadrupletAtEnd;

        if(beginColumn == 0 && beginRow != 3 || beginRow == 9 && beginColumn != 6) {
            isQuadrupletAtBeginning = true;
            isQuadrupletAtEnd = false;
        } else if(beginColumn == 6 && beginRow != 9 || beginRow == 3 && beginColumn != 0) {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = true;
        } else if((beginRow == 3 && beginColumn == 0) || (beginRow == 9 && beginColumn == 6)) {
            isQuadrupletAtBeginning = true;
            isQuadrupletAtEnd = true;
        } else {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = false;
        }

        Character currentElement = fullBoard[beginRow][beginColumn];

        if(isQuadrupletAtBeginning && !isQuadrupletAtEnd) {
            return currentElement != fullBoard[beginRow- QUADRUPLET_SIZE][beginColumn+ QUADRUPLET_SIZE];
        } else if(isQuadrupletAtEnd && !isQuadrupletAtBeginning) {
            return currentElement != fullBoard[beginRow- PREVIOUS_QUADRUPLET_OFFSET][beginColumn+ PREVIOUS_QUADRUPLET_OFFSET];
        } else if(!isQuadrupletAtBeginning && !isQuadrupletAtEnd){
            return currentElement != fullBoard[beginRow- PREVIOUS_QUADRUPLET_OFFSET][beginColumn+ PREVIOUS_QUADRUPLET_OFFSET]
                    && (currentElement != fullBoard[beginRow- QUADRUPLET_SIZE][beginColumn+ QUADRUPLET_SIZE]);
        } else return true;
    }
}
