package Win;

import java.util.stream.Stream;

public class WinningRules {

    public static Integer countHorizontal(Character[][] fullBoard, Character currentStone) {
        Integer liveStones = 0;
        for(int row = 0; row < 10; row++){
            Character[] currentRow = fullBoard[row];
            int col = 0;
            if(!isFifthElementEqual(currentRow, col)){
                liveStones += check4(currentRow, col, currentStone);
            }
            for (col = 1; col < 5; col++){
                if(!isFifthElementEqual(fullBoard[row], col) && !isPreviousElementEqual(fullBoard[row], col)) {
                    liveStones += check4(currentRow, col, currentStone);
                }
            }
            col = 5;
            if(!isPreviousElementEqual(fullBoard[row], col)) {
                liveStones += check4(currentRow, col, currentStone);
            }
            
        }
        
        return liveStones;
    }
    
    private static Boolean isFifthElementEqual(Character[] boardRow, Integer col){
        return boardRow[col] == boardRow[col + 4];
    }
    
    private static Boolean isPreviousElementEqual(Character[] boardRow, Integer col){
        return boardRow[col] == boardRow[col - 1];
    }
    
    private static Integer check4(Character[] boardRow, Integer col, Character currentStone) {
        if(Stream.of(boardRow[col], boardRow[col + 1],boardRow[col + 2],boardRow[col + 3])
                .allMatch(currentStone::equals)) {
            return 4;
        } else return 0;
    }
}
