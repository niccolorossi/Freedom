package winning.rules;

import java.util.stream.IntStream;

public class VerticalRules implements Rules {

    private Integer beginRowOfUppermostVerticalQuadruplets;
    private Integer beginRowOfLowermostVerticalQuadruplets;
    
    public VerticalRules(Integer beginRowOfUppermostVerticalQuadruplets,
                         Integer beginRowOfLowermostVerticalQuadruplets) {
        this.beginRowOfUppermostVerticalQuadruplets = beginRowOfUppermostVerticalQuadruplets;
        this.beginRowOfLowermostVerticalQuadruplets = beginRowOfLowermostVerticalQuadruplets;
    }
    
    @Override
    public Boolean isValid(Character[][] fullBoard, Integer beginRow, Integer beginColumn, Character currentStone) {

        return IntStream.range(0, QUADRUPLET_SIZE).mapToObj(i -> fullBoard[beginRow+i][beginColumn])
                .allMatch(Character.valueOf(currentStone)::equals);
    }

    @Override
    public Boolean isCandidate(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        boolean isQuadrupletAtBeginning;
        boolean isQuadrupletAtEnd;

        if (beginRow == beginRowOfUppermostVerticalQuadruplets) {
            isQuadrupletAtBeginning = true;
            isQuadrupletAtEnd = false;
        } else if (beginRow == beginRowOfLowermostVerticalQuadruplets) {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = true;
        } else {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = false;
        }

        Character currentElement = fullBoard[beginRow][beginColumn];

        if (isQuadrupletAtBeginning) {
            return currentElement != fullBoard[beginRow + QUADRUPLET_SIZE][beginColumn];
        } else if (isQuadrupletAtEnd) {
           return currentElement != fullBoard[beginRow + PREVIOUS_QUADRUPLET_OFFSET][beginColumn];
        } else {
            return currentElement != fullBoard[beginRow + PREVIOUS_QUADRUPLET_OFFSET][beginColumn]
                    && currentElement != fullBoard[beginRow + QUADRUPLET_SIZE][beginColumn];
        }
    }
}
