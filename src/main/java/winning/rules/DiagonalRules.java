package winning.rules;

import java.util.stream.IntStream;

public class DiagonalRules implements Rules {

    private Integer beginRowOfUppermostDiagonalQuadruplets;
    private Integer beginColOfUppermostDiagonalQuadruplets;
    private Integer beginRowOfLowermostDiagonalQuadruplets;
    private Integer beginColOfLowermostDiagonalQuadruplets;
    
    public DiagonalRules(Integer beginRowOfUppermostDiagonalQuadruplets,
                         Integer beginColOfUppermostDiagonalQuadruplets,
                         Integer beginRowOfLowermostDiagonalQuadruplets,
                         Integer beginColOfLowermostDiagonalQuadruplets) {
        this.beginRowOfUppermostDiagonalQuadruplets = beginRowOfUppermostDiagonalQuadruplets;
        this.beginColOfUppermostDiagonalQuadruplets = beginColOfUppermostDiagonalQuadruplets;
        this.beginRowOfLowermostDiagonalQuadruplets = beginRowOfLowermostDiagonalQuadruplets;
        this.beginColOfLowermostDiagonalQuadruplets = beginColOfLowermostDiagonalQuadruplets;
    }

    @Override
    public Boolean isValid(Character[][] fullBoard, Integer beginRow, Integer beginColumn, Character currentStone) {

        return IntStream.range(0, QUADRUPLET_SIZE).mapToObj(i -> fullBoard[beginRow+i][beginColumn+i])
                .allMatch(currentStone::equals);
    }
    
    @Override
    public Boolean isCandidate(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        boolean isQuadrupletAtBeginning;
        boolean isQuadrupletAtEnd;

        if(beginColumn.equals(beginColOfUppermostDiagonalQuadruplets) && !beginRow.equals(beginRowOfLowermostDiagonalQuadruplets)
                || beginRow.equals(beginRowOfUppermostDiagonalQuadruplets) && !beginColumn.equals(beginColOfLowermostDiagonalQuadruplets)) {
            isQuadrupletAtBeginning = true;
            isQuadrupletAtEnd = false;
        } else if(beginColumn.equals(beginColOfLowermostDiagonalQuadruplets) && !beginRow.equals(beginRowOfUppermostDiagonalQuadruplets) 
                || beginRow.equals(beginRowOfLowermostDiagonalQuadruplets) && !beginColumn.equals(beginColOfUppermostDiagonalQuadruplets)) {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = true;
        } else if(beginRow.equals(beginRowOfUppermostDiagonalQuadruplets) || beginRow.equals(beginRowOfLowermostDiagonalQuadruplets)) {
            isQuadrupletAtBeginning = true;
            isQuadrupletAtEnd = true;
        } else {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = false;
        }

        Character currentElement = fullBoard[beginRow][beginColumn];

        if(isQuadrupletAtBeginning && !isQuadrupletAtEnd) {
            return currentElement != fullBoard[beginRow + QUADRUPLET_SIZE][beginColumn + QUADRUPLET_SIZE];
        } else if(isQuadrupletAtEnd && !isQuadrupletAtBeginning) {
            return currentElement != fullBoard[beginRow + PREVIOUS_QUADRUPLET_OFFSET][beginColumn+ PREVIOUS_QUADRUPLET_OFFSET];
        } else if(!isQuadrupletAtBeginning) {
            return currentElement != fullBoard[beginRow + PREVIOUS_QUADRUPLET_OFFSET][beginColumn + PREVIOUS_QUADRUPLET_OFFSET]
                    && currentElement != fullBoard[beginRow + QUADRUPLET_SIZE][beginColumn + QUADRUPLET_SIZE];
        } else return true;
    }
}
