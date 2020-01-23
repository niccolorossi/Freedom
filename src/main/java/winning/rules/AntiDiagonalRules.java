package winning.rules;

import game.Board;

import java.util.ArrayList;
import java.util.List;
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

        return checkIfQuadrupletIsCandidate(fullBoard, beginRow,beginColumn);
    }

    private List<Boolean> positionOfQuadruplet(Integer beginRow, Integer beginColumn) {
        List<Boolean> postionOnTheBoard = new ArrayList<>();
        if(checkIfQuadrupletIsAtTheBeginningAndNotAtTheEnd(beginRow, beginColumn)) {
            postionOnTheBoard.add(true);
            postionOnTheBoard.add(false);
        } else if(checkIfQuadrupletIsAtTheEndAndNotAtTheBeginning(beginRow, beginColumn)) {
            postionOnTheBoard.add(false);
            postionOnTheBoard.add(true);
        } else if(checkIfQuadrupletIsBothAtTheBeginningAndAtTheEnd(beginRow, beginColumn)) {
            postionOnTheBoard.add(true);
            postionOnTheBoard.add(true);
        } else {
            postionOnTheBoard.add(false);
            postionOnTheBoard.add(false);
        }

        return postionOnTheBoard;
    }

    private Boolean checkIfQuadrupletIsAtTheBeginningAndNotAtTheEnd(Integer beginRow, Integer beginColumn){
        return beginColumn.equals(beginColOfLowermostAntiDiagonalQuadruplets) && !beginRow.equals(beginRowOfUppermostAntiDiagonalQuadruplets)
                || beginRow.equals(beginRowOfLowermostAntiDiagonalQuadruplets) && !beginColumn.equals(beginColOfUppermostAntiDiagonalQuadruplets);
    }

    private Boolean checkIfQuadrupletIsAtTheEndAndNotAtTheBeginning(Integer beginRow, Integer beginColumn) {
        return beginColumn.equals(beginColOfUppermostAntiDiagonalQuadruplets) && !beginRow.equals(beginRowOfLowermostAntiDiagonalQuadruplets)
                || beginRow.equals(beginRowOfUppermostAntiDiagonalQuadruplets) && !beginColumn.equals(beginColOfLowermostAntiDiagonalQuadruplets);
    }

    private Boolean checkIfQuadrupletIsBothAtTheBeginningAndAtTheEnd(Integer beginRow, Integer beginColumn) {
        return beginRow.equals(beginRowOfUppermostAntiDiagonalQuadruplets) || beginRow.equals(beginRowOfLowermostAntiDiagonalQuadruplets);
    }

    private Boolean checkIfQuadrupletIsCandidate(Board fullBoard, Integer beginRow, Integer beginColumn  ) {

        List<Boolean> positionOnTheBoard = positionOfQuadruplet(beginRow, beginColumn);

        Boolean isQuadrupletAtBeginning = positionOnTheBoard.get(0);
        Boolean isQuadrupletAtEnd = positionOnTheBoard.get(1);
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

