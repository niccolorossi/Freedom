package winning.straight;

import winning.quadruplets.QuadrupletsCounter;

public class HorizontalCounter {
    
    private static Integer getBoardSize(Character[][] fullBoard) {
        
        return fullBoard[0].length;
    }
    
    private static Character[] getCurrentRow(Character[][] fullBoard, Integer row) {
        
        return fullBoard[row];
    }
    
    public static Integer countHorizontal(Character[][] fullBoard, Character currentStone) {

        Integer size = getBoardSize(fullBoard);
        Integer liveStones = 0;
        
        for(int row = 0; row < size; row++) {
            Character[] currentRow = getCurrentRow(fullBoard, row);
            liveStones += QuadrupletsCounter.countQuadrupletsInArray(currentRow, currentStone);
        }
        return liveStones;
    }
    
}
