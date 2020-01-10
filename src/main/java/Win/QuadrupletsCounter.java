package Win;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuadrupletsCounter {

    public static Integer countQuadrupletsInArray(Character[] array, Character currentStone) {

        Integer liveStones = 0;
        Integer size = array.length;
        Integer beginOfLastQuadruplet = getBeginOfLastQuadruplet(size);

        int index = 0;

        while (index <= beginOfLastQuadruplet) {
            if (isQuadrupletCandidate(array, index) && array[index] == currentStone) {
                if (isQuadrupletValid(array, index, currentStone)) {
                    liveStones += 4;
                    index += 4;
                }
            }
            index++;
        }
        return liveStones;
    }

    private static Integer getBeginOfLastQuadruplet(Integer boardSize) {

        return boardSize - 4;
    }

    private static Boolean isFifthElementEqualToFirst(Character[] row, Integer index) {

        if (index == 6) {
            return false;
        } else return (row[index] == row[index + 4]);
    }

    private static Boolean isPreviousElementEqualToFirst(Character[] row, Integer index) {

        if (index == 0) {
            return false;
        } else return (row[index] == row[index - 1]);
    }

    private static Boolean isQuadrupletCandidate(Character[] row, Integer beginIndex) {

        return !(isPreviousElementEqualToFirst(row, beginIndex) && isFifthElementEqualToFirst(row, beginIndex));
    }
    
    private static Boolean isQuadrupletValid(Character[] currentRow, Integer beginIndex, Character currentStone) {

        List<Character> quadruplet = Arrays.stream(currentRow, beginIndex, beginIndex + 4).collect(Collectors.toList());
        return quadruplet.stream().allMatch(currentStone::equals);
        
    }
}
