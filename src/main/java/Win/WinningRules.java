package Win;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import static java.util.stream.IntStream.range;

public class WinningRules {

    public static Integer countHorizontal(Character[][] fullBoard, Character currentStone) {
        Integer liveStones = 0;
        for(int row = 0; row < 10; row++){
            Character[] currentRow = fullBoard[row];
            int col = 0;
            if(!isFifthElementEqual(currentRow, col)){
                liveStones += check4(currentRow, col, currentStone);
            }
            for (col = 1; col < 6; col++){
                if(!isFifthElementEqual(fullBoard[row], col) && !isPreviousElementEqual(fullBoard[row], col)) {
                    liveStones += check4(currentRow, col, currentStone);
                }
            }
            col = 6;
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
    
    

    public static Integer countVertical(Character[][] fullBoard, Character currentStone) {


        Character[][] fullBoardTransposed;
        fullBoardTransposed = transpose(fullBoard);
        
        return countHorizontal(fullBoardTransposed, currentStone);
    }


    /*private static  UnaryOperator<Character[][]> transpose(Character[][] board) {

        

        return m -> range(0, 10).mapToObj(r ->
                range(0, 10).mapToDouble(c -> board[c][r]).toArray()
        ).toArray(Character[][]::new);
    }*/
    
    private static Character [][] transpose(Character[][] board){
        
        int size = board[0].length;
        Character[][] transposedBoard = new Character[size][size];
        
        for(int row = 0;  row < 10; row++){
            for(int col = 0; col < 10; col++){
                transposedBoard[row][col] = board[col][row];
            }
        }
        
        return  transposedBoard;
    }
}
