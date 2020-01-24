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
        
        Character[][] currentBoard = fullBoard.currentBoard();
        boolean isQuadrupletAtBeginning;
        boolean isQuadrupletAtEnd;

        isQuadrupletAtBeginning = beginRow.equals(beginRowOfUppermostVerticalQuadruplets);
        isQuadrupletAtEnd = beginRow.equals(beginRowOfLowermostVerticalQuadruplets);

        Character firstElementOfThisQuadruplet = currentBoard[beginRow][beginColumn];
        Character firstElementOfNextQuadruplet;
        Character lastElementOfPreviousQuadruplet;
        
        
        if (isQuadrupletAtBeginning) {
            firstElementOfNextQuadruplet = currentBoard[beginRow + QUADRUPLET_SIZE][beginColumn];
            return firstElementOfThisQuadruplet != firstElementOfNextQuadruplet;
        } else if (isQuadrupletAtEnd) {
            lastElementOfPreviousQuadruplet = currentBoard[beginRow + PREVIOUS_QUADRUPLET_OFFSET][beginColumn];
           return firstElementOfThisQuadruplet != lastElementOfPreviousQuadruplet;
        } else {
            firstElementOfNextQuadruplet = currentBoard[beginRow + QUADRUPLET_SIZE][beginColumn];
            lastElementOfPreviousQuadruplet = currentBoard[beginRow + PREVIOUS_QUADRUPLET_OFFSET][beginColumn];
            return firstElementOfThisQuadruplet != firstElementOfNextQuadruplet
                    && firstElementOfThisQuadruplet != lastElementOfPreviousQuadruplet;
        }
    }
}
