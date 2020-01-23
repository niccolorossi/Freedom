package game.freedom;

public class CloseCellsLimits {
    
    private Integer leftColumnIndex;
    private Integer rightColumnIndex;
    private Integer lowerRowIndex;
    private Integer upperRowIndex;
    
    CloseCellsLimits(Integer boardSize, Integer row, Integer column) {

        upperRowIndex = (row == 1) ? row : row - 1;

        leftColumnIndex = (column == 1) ? column : column - 1;

        lowerRowIndex = (row == boardSize) ? row : row + 1;

        rightColumnIndex = (column == boardSize) ? column : column + 1;
    }
    
    Integer getLeftColumnIndex() {

        return leftColumnIndex;
    }
    Integer getRightColumnIndex() {
        return rightColumnIndex;
    }
    Integer getLowerRowIndex() {
        return  lowerRowIndex;
    }
    Integer getUpperRowIndex() {
        return upperRowIndex;
    }






}
