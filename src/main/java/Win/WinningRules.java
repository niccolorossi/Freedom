package Win;

import java.util.stream.Stream;

public class WinningRules {
    
    private static Integer getBoardSize(Character[][] fullBoard) {
        
        return fullBoard[0].length;
    }
    
    private static Character[] getCurrentRow(Character[][] fullBoard, Integer row) {
        
        return fullBoard[row];
    }
    
    private static Boolean possibleFiveStonesStraightNext(Character[] row, Integer index) {
        
        if(index == 6) {
            return true;
        } else return !(row[index] == row[index + 4]);
    }
    
    private static Boolean possibleFiveStonesStraightPrevious(Character[] row, Integer index) {
        
        if(index == 0) {
            return true;
        } else return !(row[index] == row[index-1]);
    }
    
    private static Boolean isValidQuadruplet(Character[] row, Integer beginIndex) {
        
        return possibleFiveStonesStraightPrevious(row, beginIndex) && possibleFiveStonesStraightNext(row, beginIndex);
    }
    
  
    
    

    public static Integer countHorizontal(Character[][] fullBoard, Character currentStone) {

        Integer size = getBoardSize(fullBoard);
        Integer liveStones = 0;
        
        for(int row = 0; row < size; row++) {
            Character[] currentRow = getCurrentRow(fullBoard, row);
            for(int col = 0; col < 7; col++) {
                if(row == 8) System.out.println(isValidQuadruplet(currentRow, col));
                if(isValidQuadruplet(currentRow, col)) {
                    liveStones += check4(currentRow, col, currentStone);
                }
            }
        }
        return liveStones;
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
