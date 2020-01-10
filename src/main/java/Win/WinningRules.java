package Win;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

public class WinningRules {
    
    private static Integer getBoardSize(Character[][] fullBoard) {
        
        return fullBoard[0].length;
    }
    
    private static Character[] getCurrentRow(Character[][] fullBoard, Integer row) {
        
        return fullBoard[row];
    }
    
    private static Integer getBeginOfLastQuadruplet(Integer boardSize) {
        
        return boardSize-4;
    }
    
    private static Boolean possibleFiveStonesStraightNext(Character[] row, Integer index) {
        
        if(index == 6) {
            return false;
        } else return (row[index] == row[index + 4]);
    }
    
    private static Boolean possibleFiveStonesStraightPrevious(Character[] row, Integer index) {
        
        if(index == 0) {
            return false;
        } else return (row[index] == row[index-1]);
    }
    
    private static Boolean isValidQuadruplet(Character[] row, Integer beginIndex) {
        
        return !(possibleFiveStonesStraightPrevious(row, beginIndex) && possibleFiveStonesStraightNext(row, beginIndex));
    }
    
    public static Integer countQuadrupletsInArray(Character[] array, Character currentStone) {
        
        Integer liveStones = 0;
        Integer size = array.length;
        Integer beginOfLastQuadruplet = getBeginOfLastQuadruplet(size);
        
        
        for(int index = 0; index <= beginOfLastQuadruplet; index++) {
            if(isValidQuadruplet(array, index)) {
                liveStones += checkQuadruplet(array, index, currentStone);
            }
        }
        
        return liveStones;
    }
    
    public static Integer countHorizontal(Character[][] fullBoard, Character currentStone) {

        Integer size = getBoardSize(fullBoard);
        Integer liveStones = 0;
        Integer beginOfLastQuadruplet = getBeginOfLastQuadruplet(size);
        
        for(int row = 0; row < size; row++) {
            Character[] currentRow = getCurrentRow(fullBoard, row);
            for(int col = 0; col <= beginOfLastQuadruplet; col++) {
                if(isValidQuadruplet(currentRow, col)) {
                    liveStones += checkQuadruplet(currentRow, col, currentStone);
                }
            }
        }
        return liveStones;
    }
    
    private static Integer checkQuadruplet(Character[] currentRow, Integer beginIndex, Character currentStone) {
        
        List<Character> quadruplet = Arrays.stream(currentRow, beginIndex, beginIndex + 4).collect(Collectors.toList());

        boolean quadrupletMatchesCurrentStone = quadruplet.stream().allMatch(currentStone::equals);
        
        if (quadrupletMatchesCurrentStone) {
            return 4;
        } else return 0;
    }
    

    public static Integer countVertical(Character[][] fullBoard, Character currentStone) {


        Character[][] fullBoardTransposed;
        fullBoardTransposed = transpose(fullBoard);
        return countHorizontal(fullBoardTransposed, currentStone);
    }
    
    private static Character [][] transpose(Character[][] board){
        
        int size = board[0].length;
        Character[][] transposedBoard = new Character[size][size];
        
        for(int row = 0;  row < 10; row++){
            for(int col = 0; col < 10; col++){
                transposedBoard[row][col] = board[col][row];
            }
        }
        
        return transposedBoard;
    }
}
