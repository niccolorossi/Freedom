package winning.rules;

import game.Board;

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
    public Boolean isValid(Board fullBoard, Integer beginRow, Integer beginColumn, Character currentStone) {

        return IntStream.range(0, QUADRUPLET_SIZE).mapToObj(i -> fullBoard.currentBoard()[beginRow+i][beginColumn])
                .allMatch(currentStone::equals);
    }

    @Override
    public Boolean isCandidate(Board fullBoard, Integer beginRow, Integer beginColumn) {
        boolean isQuadrupletAtBeginning;
        boolean isQuadrupletAtEnd;

        if (beginRow.equals(beginRowOfUppermostVerticalQuadruplets)) {
            isQuadrupletAtBeginning = true;
            isQuadrupletAtEnd = false;
        } else if (beginRow.equals(beginRowOfLowermostVerticalQuadruplets)) {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = true;
        } else {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = false;
        }

        Character currentElement = fullBoard.currentBoard()[beginRow][beginColumn];

        if (isQuadrupletAtBeginning) {
            return currentElement != fullBoard.currentBoard()[beginRow + QUADRUPLET_SIZE][beginColumn];
        } else if (isQuadrupletAtEnd) {
           return currentElement != fullBoard.currentBoard()[beginRow + PREVIOUS_QUADRUPLET_OFFSET][beginColumn];
        } else {
            return currentElement != fullBoard.currentBoard()[beginRow + PREVIOUS_QUADRUPLET_OFFSET][beginColumn]
                    && currentElement != fullBoard.currentBoard()[beginRow + QUADRUPLET_SIZE][beginColumn];
        }
    }
}
