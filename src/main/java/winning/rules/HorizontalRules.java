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
        
        Character[][] currentBoard = fullBoard.currentBoard();
        boolean isQuadrupletAtBeginning;
        boolean isQuadrupletAtEnd;

        isQuadrupletAtBeginning = beginColumn.equals(beginColOfLeftmostHorizontalQuadruplets);
        isQuadrupletAtEnd = beginColumn.equals(beginColOfRightmostHorizontalQuadruplets);

        Character firstElementOfThisQuadruplet = currentBoard[beginRow][beginColumn];
        Character firstElementOfNextQuadruplet;
        Character lastElementOfPreviousQuadruplet; 

        if(isQuadrupletAtBeginning) {
            firstElementOfNextQuadruplet = currentBoard[beginRow][beginColumn+QUADRUPLET_SIZE];
            return !firstElementOfThisQuadruplet.equals(firstElementOfNextQuadruplet);
        } else if(isQuadrupletAtEnd) {
            lastElementOfPreviousQuadruplet = currentBoard[beginRow][beginColumn+PREVIOUS_QUADRUPLET_OFFSET];
            return !firstElementOfThisQuadruplet.equals(lastElementOfPreviousQuadruplet);
        } else {
            firstElementOfNextQuadruplet = currentBoard[beginRow][beginColumn+QUADRUPLET_SIZE];
            lastElementOfPreviousQuadruplet = currentBoard[beginRow][beginColumn+PREVIOUS_QUADRUPLET_OFFSET];
            return !firstElementOfThisQuadruplet.equals(firstElementOfNextQuadruplet)
                    && !firstElementOfThisQuadruplet.equals(lastElementOfPreviousQuadruplet);
        }
    }
    
    
}
