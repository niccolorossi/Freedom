package winning.rules;

import game.Board;

import java.util.stream.IntStream;

public class AntiDiagonalRules implements Rules {
    
    private Integer beginRowOfLowermostAntiDiagonalQuadruplets;
    private Integer beginColOfLowermostAntiDiagonalQuadruplets;
    private Integer beginRowOfUppermostAntiDiagonalQuadruplets;
    private Integer beginColOfUppermostAntiDiagonalQuadruplets;

    public AntiDiagonalRules(Integer beginRowOfLowermostAntiDiagonalQuadruplets,
                             Integer beginColOfLowermostAntiDiagonalQuadruplets,
                             Integer beginRowOfUppermostAntiDiagonalQuadruplets,
                             Integer beginColOfUppermostAntiDiagonalQuadruplets) {
        this.beginRowOfLowermostAntiDiagonalQuadruplets = beginRowOfLowermostAntiDiagonalQuadruplets;
        this.beginColOfLowermostAntiDiagonalQuadruplets = beginColOfLowermostAntiDiagonalQuadruplets;
        this.beginRowOfUppermostAntiDiagonalQuadruplets = beginRowOfUppermostAntiDiagonalQuadruplets;
        this.beginColOfUppermostAntiDiagonalQuadruplets = beginColOfUppermostAntiDiagonalQuadruplets;
    }
 
    @Override
    public Boolean isValid(Board fullBoard, Integer beginRow, Integer beginColumn, Character currentStone) {

        return IntStream.range(0, QUADRUPLET_SIZE).mapToObj(i -> fullBoard.currentBoard()[beginRow-i][beginColumn+i])
                .allMatch(currentStone::equals);
    }

    @Override
    public Boolean isCandidate(Board fullBoard, Integer beginRow, Integer beginColumn) {

        Character[][] currentBoard = fullBoard.currentBoard();
        boolean isQuadrupletAtBeginning;
        boolean isQuadrupletAtEnd;

        isQuadrupletAtBeginning = beginRow.equals(beginRowOfLowermostAntiDiagonalQuadruplets) ||
                beginColumn.equals(beginColOfLowermostAntiDiagonalQuadruplets);

        isQuadrupletAtEnd = beginRow.equals(beginRowOfUppermostAntiDiagonalQuadruplets) ||
                beginColumn.equals(beginColOfUppermostAntiDiagonalQuadruplets);

        Character firstElementOfThisQuadruplet = currentBoard[beginRow][beginColumn];
        Character firstElementOfNextQuadruplet;
        Character lastElementOfPreviousQuadruplet;
        
        
        
        if(isQuadrupletAtBeginning && !isQuadrupletAtEnd) {
            firstElementOfNextQuadruplet = currentBoard[beginRow- QUADRUPLET_SIZE][beginColumn+ QUADRUPLET_SIZE];
            return firstElementOfThisQuadruplet != firstElementOfNextQuadruplet;
        } else if(isQuadrupletAtEnd && !isQuadrupletAtBeginning) {
            lastElementOfPreviousQuadruplet = currentBoard[beginRow- PREVIOUS_QUADRUPLET_OFFSET][beginColumn+ PREVIOUS_QUADRUPLET_OFFSET];
            return firstElementOfThisQuadruplet != lastElementOfPreviousQuadruplet;
        } else if(!isQuadrupletAtBeginning){
            firstElementOfNextQuadruplet = currentBoard[beginRow- QUADRUPLET_SIZE][beginColumn+ QUADRUPLET_SIZE];
            lastElementOfPreviousQuadruplet = currentBoard[beginRow- PREVIOUS_QUADRUPLET_OFFSET][beginColumn+ PREVIOUS_QUADRUPLET_OFFSET];
            return firstElementOfThisQuadruplet != firstElementOfNextQuadruplet
                    && (firstElementOfThisQuadruplet != lastElementOfPreviousQuadruplet);
        } else return true;
    }

    
    
       
}

