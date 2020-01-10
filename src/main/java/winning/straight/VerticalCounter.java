package winning.straight;

import static winning.straight.HorizontalCounter.countHorizontal;

public class VerticalCounter {

    public static Integer countVertical(Character[][] fullBoard, Character currentStone) {
        
        Character[][] fullBoardTransposed;
        fullBoardTransposed = transpose(fullBoard);
        return countHorizontal(fullBoardTransposed, currentStone);
    }

    private static Character [][] transpose(Character[][] board){

        int size = board[0].length;
        Character[][] transposedBoard = new Character[size][size];

        for(int row = 0;  row < size; row++){
            for(int col = 0; col < size; col++){
                transposedBoard[row][col] = board[col][row];
            }
        }
        return transposedBoard;
    }
}
