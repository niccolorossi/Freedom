package freedom;

import java.util.ArrayList;
import java.util.List;

public class CloseCells {
    private List<Character> closeValues;
    private CloseCellsIndexes cci;
    
    CloseCells(Board board, Integer row, Integer column){
        
        cci = new CloseCellsIndexes(board.getBoardSize(), row, column);

        this.closeValues = new ArrayList<>();
        for(int i = cci.getUpperRowIndex(); i <= cci.getLowerRowIndex(); i++) {
            for(int j = cci.getLeftColumnIndex(); j<= cci.getRightColumnIndex(); j++) {
                closeValues.add(board.getStone(i,j));
            }
        }
        
    }
    
    List<Character> getCloseValues() {return closeValues;}
    
    
    
}
