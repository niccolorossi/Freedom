package winning.rules;

import java.util.stream.IntStream;

public class AntiDiagonalRules implements Rules {
    
    private Integer beginRowOfLowermostAntiDiagonals;
    private Integer beginColOfLowermostAntiDiagonals;
    private Integer beginRowOfUppermostAntiDiagonals;
    private Integer beginColOfUppermostAntiDiagonals;

    public AntiDiagonalRules(Integer beginRowOfLowermostAntiDiagonals,
                             Integer beginColOfLowermostAntiDiagonals,
                             Integer beginRowOfUppermostAntiDiagonals,
                             Integer beginColOfUppermostAntiDiagonals) {
        this.beginRowOfLowermostAntiDiagonals = beginRowOfLowermostAntiDiagonals;
        this.beginColOfLowermostAntiDiagonals = beginColOfLowermostAntiDiagonals;
        this.beginRowOfUppermostAntiDiagonals = beginRowOfUppermostAntiDiagonals;
        this.beginColOfUppermostAntiDiagonals = beginColOfUppermostAntiDiagonals;
    }
 
    @Override
    public Boolean isValid(Character[][] fullBoard, Integer beginRow, Integer beginColumn, Character currentStone) {

        return IntStream.range(0, QUADRUPLET_SIZE).mapToObj(i -> fullBoard[beginRow-i][beginColumn+i])
                .allMatch(Character.valueOf(currentStone)::equals);
    }

    @Override
    public Boolean isCandidate(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        boolean isQuadrupletAtBeginning;
        boolean isQuadrupletAtEnd;

        if(beginColumn == beginColOfLowermostAntiDiagonals && beginRow != beginRowOfUppermostAntiDiagonals 
                || beginRow == beginRowOfLowermostAntiDiagonals && beginColumn != beginColOfUppermostAntiDiagonals) {
            isQuadrupletAtBeginning = true;
            isQuadrupletAtEnd = false;
        } else if(beginColumn == beginRowOfUppermostAntiDiagonals && beginRow != beginRowOfLowermostAntiDiagonals 
                || beginRow == beginRowOfUppermostAntiDiagonals && beginColumn != beginColOfLowermostAntiDiagonals) {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = true;
        } else if((beginRow == beginRowOfUppermostAntiDiagonals && beginColumn == beginColOfLowermostAntiDiagonals) 
                || (beginRow == beginRowOfLowermostAntiDiagonals && beginColumn == beginColOfUppermostAntiDiagonals)) {
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
