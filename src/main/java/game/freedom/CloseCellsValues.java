package game.freedom;

import game.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CloseCellsValues {
    
    private List<Character> closeValues;
    private CloseCellsLimits closeCellsLimits;
    
    CloseCellsValues(Board board, Integer row, Integer column) {

        this.closeCellsLimits = new CloseCellsLimits(board.size(), row, column);
        this.closeValues = closeValues(board);

    }

    private List<Character> closeValues(Board board) {

        Integer upperRow = closeCellsLimits.getUpperRowIndex();
        Integer lowerRow = closeCellsLimits.getLowerRowIndex();
        Integer leftColumn = closeCellsLimits.getLeftColumnIndex();
        Integer rightColumn = closeCellsLimits.getRightColumnIndex();
        List <Character> closeValues = new ArrayList<>();

        for (int row = upperRow; row <= lowerRow; row++) {
            Integer currentRow = row;
            List<Character> rowCharactersList = IntStream.rangeClosed(leftColumn, rightColumn)
                    .mapToObj(c -> board.stone(currentRow, c)).collect(Collectors.toList());
            closeValues.addAll(rowCharactersList);
        }
        return closeValues;
    }

    List<Character> getCloseValues() {
        return closeValues;
    }

    
}
