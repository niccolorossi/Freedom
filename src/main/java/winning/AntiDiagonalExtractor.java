package winning;

import java.util.ArrayList;
import java.util.List;

public class AntiDiagonalExtractor {
    
    public static List<Character[]> extractAntiDiagonals(Character[][] fullBoard) {

        List<Character[]> toReturn = new ArrayList<>();
        List<Character[]> upperDiagonalsList = new ArrayList<>();
        List<Character[]> lowerDiagonalsList = new ArrayList<>();
        Integer size = fullBoard[0].length;
        Integer numberOfUpperDiagonals = size-4;

        for(int d=1; d<=numberOfUpperDiagonals; d++) {
            upperDiagonalsList.add(extractAntiDiagonal(fullBoard, d, true));
            lowerDiagonalsList.add(extractAntiDiagonal(fullBoard, d, false));
        }
        toReturn.addAll(upperDiagonalsList);
        toReturn.addAll(lowerDiagonalsList);
        toReturn.add(extractMainAntiDiagonal(fullBoard));
        return toReturn;
    }
    
    private static Character[] extractAntiDiagonal(Character[][] fullBoard, Integer diagonalIdentifier, Boolean isUpper) {
        
        int row;
        int column;
        Integer size = fullBoard[0].length;

        Integer diagonalSize = getSizeOfDiagonalWithGivenIdentifier(size, diagonalIdentifier);
        Character[] toReturn = new Character[diagonalSize];

        for(int index=0; index<diagonalSize; index++) {
            if (!isUpper) {
                row = index + diagonalIdentifier;
                column = size - index - 1;
                toReturn[index] = fullBoard[row][column];
            } else {
                row = index;
                column = size - index - 1 - diagonalIdentifier;
                toReturn[index] = fullBoard[row][column];
            }
        }
        return toReturn;
    }

    private static Integer getSizeOfDiagonalWithGivenIdentifier(Integer boardSize, Integer diagonalIdentifier) {

        return boardSize - diagonalIdentifier;
    }

    private static Character[] extractMainAntiDiagonal(Character[][] fullBoard) {

        Integer size = fullBoard[0].length;
        Character[] toReturn = new Character[size];
        for(int row=0; row<size; row++) {
            toReturn[row] = fullBoard[row][size-row-1];
        }
        return toReturn;
    }
}
