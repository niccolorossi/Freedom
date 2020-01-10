package winning.diagonals;

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
            upperDiagonalsList.add(extractDiagonal(fullBoard, d, true));
            lowerDiagonalsList.add(extractDiagonal(fullBoard, d, false));
        }
        toReturn.addAll(upperDiagonalsList);
        toReturn.addAll(lowerDiagonalsList);
        toReturn.add(extractMainDiagonal(fullBoard));
        return toReturn;
    }
    
    private static Character[] extractDiagonal(Character[][] fullBoard, Integer diagonalIdentifier, Boolean isUpper) {
        
        int row;
        int column;
        Integer boardSize = fullBoard[0].length;
        Integer diagonalSize = boardSize-diagonalIdentifier;
        Character[] toReturn = new Character[diagonalSize];
        
        for(int index=0; index<diagonalSize; index++) {
            row=index;
            column=index+diagonalIdentifier;
            if(isUpper) {
                toReturn[index] = fullBoard[row][column];
            } else toReturn[index] = fullBoard[column][row];
        }
        
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
