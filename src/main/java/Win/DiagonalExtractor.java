package Win;

import java.util.ArrayList;
import java.util.List;

public class DiagonalExtractor {

    public static List<Character[]> extractDiagonals(Character[][] fullBoard) {

        List<Character[]> toReturn = new ArrayList<>();
        List<Character[]> upperDiagonalsList = new ArrayList<>();
        List<Character[]> lowerDiagonalsList = new ArrayList<>();
        Integer size = fullBoard[0].length;
        Integer numberOfUpperDiagonals = size-4;

        for(int d=1; d<=numberOfUpperDiagonals; d++) {
            int col;
            Character[] upperDiagonalAsArray = new Character[size-d];
            Character[] lowerDiagonalAsArray = new Character[size-d];
            for(int row=0; row<size-d; row++) {
                col = row+d;
                lowerDiagonalAsArray[row] = fullBoard[col][row];
                upperDiagonalAsArray[row] = fullBoard[row][col];
            }
            upperDiagonalsList.add(upperDiagonalAsArray);
            lowerDiagonalsList.add(lowerDiagonalAsArray);
        }
        toReturn.addAll(upperDiagonalsList);
        toReturn.addAll(lowerDiagonalsList);
        toReturn.add(extractMainDiagonal(fullBoard));
        return toReturn;
    }

    private static Character[] extractMainDiagonal(Character[][] fullBoard) {
        
        Integer size = fullBoard[0].length;
        Character[] toReturn = new Character[size];
        for(int row=0; row<size; row++) {
            toReturn[row] = fullBoard[row][row];
        }
        return toReturn;
    }
    
}
