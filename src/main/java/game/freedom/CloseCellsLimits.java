package game.freedom;

class CloseCellsLimits {
    
    private Integer leftColumnIndex;
    private Integer rightColumnIndex;
    private Integer lowerRowIndex;
    private Integer upperRowIndex;
    
    CloseCellsLimits(Integer boardSize, Integer row, Integer column) {

        upperRowIndex = startingIndex(row);
        leftColumnIndex = startingIndex(column);
        lowerRowIndex = endingIndex(row, boardSize);
        rightColumnIndex = endingIndex(column, boardSize);
    }

    private Integer startingIndex(Integer coordinate) {
        return (coordinate == 1) ? coordinate : coordinate - 1;
    }

    private Integer endingIndex(Integer coordinate, Integer boardSize) {
        return (coordinate.equals(boardSize)) ? coordinate : coordinate + 1;
    }
    
    Integer getLeftColumnIndex() { return leftColumnIndex; }
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
