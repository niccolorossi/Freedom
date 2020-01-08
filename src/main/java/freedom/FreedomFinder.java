package freedom;

import checkers.CloseCellsFinder;

import java.util.ArrayList;
import java.util.List;

public class FreedomFinder {

    public static Boolean isNextFreedom(Board board, Integer row, Integer column) {

        Character[][] currentBoard = board.getCurrentBoard();
        Character empty = board.getEmptyCellCharacter();

        Integer lowerLimitRow = CloseCellsFinder.getLowerLimit(row);
        Integer upperLimitRow = CloseCellsFinder.getUpperLimit(row);
        Integer lowerLimitColumn = CloseCellsFinder.getLowerLimit(column);
        Integer upperLimitColumn = CloseCellsFinder.getUpperLimit(column);

        List<Character> adjacentCellsCharacters = new ArrayList<>();
        for(int i = lowerLimitRow-1; i <= upperLimitRow-1; i++) {
            for(int j = lowerLimitColumn-1; j<= upperLimitColumn-1; j++) {
                adjacentCellsCharacters.add(currentBoard[i][j]);
            }
        }

        return  !adjacentCellsCharacters.stream().anyMatch(x -> x == empty);
    }
}
