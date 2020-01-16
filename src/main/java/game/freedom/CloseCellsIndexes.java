package game.freedom;

public class CloseCellsIndexes {
    private Integer leftColumnIndex;
    private Integer rightColumnIndex;
    private Integer lowerRowIndex;
    private Integer upperRowIndex;
    
    CloseCellsIndexes(Integer boardSize, Integer row, Integer column){
        if(row == 1) {
            upperRowIndex = row;
        }
        else {
            upperRowIndex = row-1;
        }
        
        if(column == 1){
            leftColumnIndex = column;
        }
        else {
            leftColumnIndex = column-1;
        }
        
        if(row == boardSize){
            lowerRowIndex = row;
        }
        else{
            lowerRowIndex = row+1;
        }
        
        if(column == boardSize){
            rightColumnIndex = column;
        }
        else {
            rightColumnIndex = column+1;
        }
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
