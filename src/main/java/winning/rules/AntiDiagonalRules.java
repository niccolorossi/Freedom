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
        boolean isQuadrupletAtBeginning;
        boolean isQuadrupletAtEnd;

        if(beginColumn.equals(beginColOfLowermostAntiDiagonalQuadruplets) && !beginRow.equals(beginRowOfUppermostAntiDiagonalQuadruplets) 
                || beginRow.equals(beginRowOfLowermostAntiDiagonalQuadruplets) && !beginColumn.equals(beginColOfUppermostAntiDiagonalQuadruplets)) {
            isQuadrupletAtBeginning = true;
            isQuadrupletAtEnd = false;
        } else if(beginColumn.equals(beginColOfUppermostAntiDiagonalQuadruplets) && !beginRow.equals(beginRowOfLowermostAntiDiagonalQuadruplets) 
                || beginRow.equals(beginRowOfUppermostAntiDiagonalQuadruplets) && !beginColumn.equals(beginColOfLowermostAntiDiagonalQuadruplets)) {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = true;
        } else if(beginRow.equals(beginRowOfUppermostAntiDiagonalQuadruplets) || beginRow.equals(beginRowOfLowermostAntiDiagonalQuadruplets)) {
            isQuadrupletAtBeginning = true;
            isQuadrupletAtEnd = true;
        } else {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = false;
        }

        Character currentElement = fullBoard.currentBoard()[beginRow][beginColumn];

        if(isQuadrupletAtBeginning && !isQuadrupletAtEnd) {
            return currentElement != fullBoard.currentBoard()[beginRow- QUADRUPLET_SIZE][beginColumn+ QUADRUPLET_SIZE];
        } else if(isQuadrupletAtEnd && !isQuadrupletAtBeginning) {
            return currentElement != fullBoard.currentBoard()[beginRow- PREVIOUS_QUADRUPLET_OFFSET][beginColumn+ PREVIOUS_QUADRUPLET_OFFSET];
        } else if(!isQuadrupletAtBeginning){
            return currentElement != fullBoard.currentBoard()[beginRow-PREVIOUS_QUADRUPLET_OFFSET][beginColumn+PREVIOUS_QUADRUPLET_OFFSET]
                    && (currentElement != fullBoard.currentBoard()[beginRow-QUADRUPLET_SIZE][beginColumn+QUADRUPLET_SIZE]);
        } else return true;
    }
}
