package winning.rules;

import game.Board;

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
    public Boolean isValid(Board fullBoard, Integer beginRow, Integer beginColumn, Character currentStone) {

        return IntStream.range(0, QUADRUPLET_SIZE).mapToObj(i -> fullBoard.currentBoard()[beginRow+i][beginColumn+i])
                .allMatch(currentStone::equals);
    }
    
    @Override
    public Boolean isCandidate(Board fullBoard, Integer beginRow, Integer beginColumn) {
        Character[][] currentBoard = fullBoard.currentBoard();
        boolean isQuadrupletAtBeginning;
        boolean isQuadrupletAtEnd;

        isQuadrupletAtBeginning = beginRow.equals(beginRowOfUppermostDiagonalQuadruplets) || 
                beginColumn.equals(beginColOfUppermostDiagonalQuadruplets);
        
        isQuadrupletAtEnd = beginRow.equals(beginRowOfLowermostDiagonalQuadruplets) || 
                beginColumn.equals(beginColOfLowermostDiagonalQuadruplets) ;

        Character firstElementOfThisQuadruplet = currentBoard[beginRow][beginColumn];
        Character firstElementOfNextQuadruplet;
        Character lastElementOfPreviousQuadruplet;
        
        
        if(isQuadrupletAtBeginning && !isQuadrupletAtEnd) {
            firstElementOfNextQuadruplet = currentBoard[beginRow + QUADRUPLET_SIZE][beginColumn + QUADRUPLET_SIZE];
            return firstElementOfThisQuadruplet != firstElementOfNextQuadruplet;
        } else if(isQuadrupletAtEnd && !isQuadrupletAtBeginning) {
            lastElementOfPreviousQuadruplet = currentBoard[beginRow + PREVIOUS_QUADRUPLET_OFFSET][beginColumn+ PREVIOUS_QUADRUPLET_OFFSET];
            return firstElementOfThisQuadruplet != lastElementOfPreviousQuadruplet;
        } else if(!isQuadrupletAtBeginning) {
            firstElementOfNextQuadruplet = currentBoard[beginRow + QUADRUPLET_SIZE][beginColumn + QUADRUPLET_SIZE];
            lastElementOfPreviousQuadruplet = currentBoard[beginRow + PREVIOUS_QUADRUPLET_OFFSET][beginColumn+ PREVIOUS_QUADRUPLET_OFFSET];
            return firstElementOfThisQuadruplet != firstElementOfNextQuadruplet
                    && firstElementOfThisQuadruplet != lastElementOfPreviousQuadruplet;
        } else return true;
    }
}
