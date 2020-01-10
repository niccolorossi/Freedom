package Win;

import java.util.ArrayList;
import java.util.List;

public class DiagonalExtractor {


    public static Character[] extractMainDiagonal(Character[][] fullBoard) {
        
        Integer size = fullBoard[0].length;
        Character[] toReturn = new Character[size];
        for(int row=0; row<size; row++) {
            toReturn[row] = fullBoard[row][row];
        }
        return toReturn;
    }

    public static Character[] extractFirstUpperDiagonal(Character[][] fullBoard) {
        
        Integer size = fullBoard[0].length;
        Character[] toReturn = new Character[size-1];
        int col;
        for(int row=0; row<size-1; row++) {
            col = row+1;
            toReturn[row] = fullBoard[row][col];
        }
        return toReturn;
    }

    public static List<Character[]> extractUpperDiagonals(Character[][] fullBoard) {
        
        List<Character[]> toReturn = new ArrayList<>();
        Integer size = fullBoard[0].length;
        Integer numberOfUpperDiagonals = size-4;
        for(int d=1; d<=numberOfUpperDiagonals; d++) {
            int col;
            Character[] diagonalAsArray = new Character[size-d];
            for(int row=0; row<size-d; row++) {
                col = row+d;
                diagonalAsArray[row] = fullBoard[row][col];
            }
            toReturn.add(diagonalAsArray);
        }
        return toReturn;
        
    }

    public static List<Character[]> extractLowerDiagonals(Character[][] fullBoard) {

        List<Character[]> toReturn = new ArrayList<>();
        Integer size = fullBoard[0].length;
        Integer numberOfUpperDiagonals = size-4;

        for(int d=1; d<=numberOfUpperDiagonals; d++) {
            int col;
            Character[] diagonalAsArray = new Character[size-d];
            for(int row=0; row<size-d; row++) {
                col = row+d;
                diagonalAsArray[row] = fullBoard[col][row];
            }
            toReturn.add(diagonalAsArray);
        }
        return toReturn;
    }
}
