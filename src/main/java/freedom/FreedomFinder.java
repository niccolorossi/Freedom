package freedom;

public class FreedomFinder {
    
    private CloseCells closeCell;
    private Boolean isNextFreedom;
    
    public FreedomFinder(Board board, Integer row, Integer column){
        closeCell = new CloseCells(board, row, column);
        isNextFreedom = !closeCell.getCloseValues().stream().anyMatch(x -> x == board.getEmptyCellCharacter());
    }

    public  Boolean isNextFreedom() {
        return  isNextFreedom;
    }
}
