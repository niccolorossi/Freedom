package winning.rules;

import game.Board;

import java.util.stream.IntStream;

public class HorizontalRules implements Rules {
    
    private Integer beginColOfLeftmostHorizontalQuadruplets;
    private Integer beginColOfRightmostHorizontalQuadruplets;


    public HorizontalRules(Integer beginColOfLeftmostHorizontalQuadruplets,
                           Integer beginColOfRightmostHorizontalQuadruplets) {
        this.beginColOfLeftmostHorizontalQuadruplets = beginColOfLeftmostHorizontalQuadruplets;
        this.beginColOfRightmostHorizontalQuadruplets = beginColOfRightmostHorizontalQuadruplets;
    }
    
    @Override
    public Boolean isValid(Board fullBoard, Integer beginRow, Integer beginColumn, Character currentStone) {
        
        return IntStream.range(0, QUADRUPLET_SIZE).mapToObj(i -> fullBoard.currentBoard()[beginRow][beginColumn+i])
                .allMatch(currentStone::equals);
    }

    @Override
    public Boolean isCandidate(Board fullBoard, Integer beginRow, Integer beginColumn) {

        boolean isQuadrupletAtBeginning;
        boolean isQuadrupletAtEnd;

        if(beginColumn.equals(beginColOfLeftmostHorizontalQuadruplets)) {
            isQuadrupletAtBeginning = true;
            isQuadrupletAtEnd = false;
        } else if(beginColumn.equals(beginColOfRightmostHorizontalQuadruplets)) {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = true;
        } else {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = false;
        }

        Character currentElement = fullBoard.currentBoard()[beginRow][beginColumn];

        if(isQuadrupletAtBeginning) {
            return currentElement != fullBoard.currentBoard()[beginRow][beginColumn + QUADRUPLET_SIZE];
        } else if(isQuadrupletAtEnd) {
            return currentElement != fullBoard.currentBoard()[beginRow][beginColumn + PREVIOUS_QUADRUPLET_OFFSET];
        } else {
            return currentElement != fullBoard.currentBoard()[beginRow][beginColumn + PREVIOUS_QUADRUPLET_OFFSET]
                    && currentElement != fullBoard.currentBoard()[beginRow][beginColumn + QUADRUPLET_SIZE];
        }
    }
}
