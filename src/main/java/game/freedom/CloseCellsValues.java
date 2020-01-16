package game.freedom;

import game.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CloseCellsValues {
    
    private List<Character> closeValues;
    
    CloseCellsValues(Board board, Integer row, Integer column) {

        CloseCellsIndexes closeCellsIndexes = new CloseCellsIndexes(board.getBoardSize(), row, column);

        Integer upperRow = closeCellsIndexes.getUpperRowIndex();
        Integer lowerRow = closeCellsIndexes.getLowerRowIndex();
        Integer leftColumn = closeCellsIndexes.getLeftColumnIndex();
        Integer rightColumn = closeCellsIndexes.getRightColumnIndex();

        this.closeValues = new ArrayList<>();

        for (row = upperRow; row <= lowerRow; row++) {
            List<Character> rowCharactersList = IntStream.rangeClosed(leftColumn, rightColumn)
                    .mapToObj(c -> board.getStone(upperRow, c)).collect(Collectors.toList());
            closeValues.addAll(rowCharactersList);
        }
    }
    
    List<Character> getCloseValues() {
        return closeValues;
    }
    
}
