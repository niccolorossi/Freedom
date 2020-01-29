package game.freedom;

import game.Board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CloseCellsValues {
    
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
            for(int col = leftColumn; col <=rightColumn; col++){
                closeValues.add(board.stone(Arrays.asList(row,col)));
            }
        }
        
        return closeValues;
    }
    
    List<Character> getCloseValues() {
        return closeValues;
    }
    
}
