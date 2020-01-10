package winning;

import java.util.List;

public class DiagonalCounter {

    public static Integer countDiagonal(Character[][] fullBoard, Character currentStone) {

        List<Character[]> diagonals = DiagonalExtractor.extractDiagonals(fullBoard);
        Integer diagonalsNumber = diagonals.size();
        Integer totalCount = 0;
        for(int i = 0; i < diagonalsNumber; i++){
            Character[] currentDiagonal = diagonals.get(i);
            totalCount += QuadrupletsCounter.countQuadrupletsInArray(currentDiagonal, currentStone);
        }
        return totalCount;
    }

    public static Integer countAntiDiagonal(Character[][] fullBoard, Character currentStone) {
        List<Character[]> diagonals = AntiDiagonalExtractor.extractAntiDiagonals(fullBoard);
        Integer diagonalsNumber = diagonals.size();
        Integer totalCount = 0;
        for(int i = 0; i < diagonalsNumber; i++){
            Character[] currentDiagonal = diagonals.get(i);
            totalCount += QuadrupletsCounter.countQuadrupletsInArray(currentDiagonal, currentStone);
        }
        return totalCount;
    }
}

