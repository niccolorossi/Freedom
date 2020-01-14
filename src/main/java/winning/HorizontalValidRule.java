package winning;

import java.util.Arrays;
import java.util.stream.IntStream;

class HorizontalValidRule implements ValidRule {

    @Override
    public Boolean isValid(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {

        Character[] quadrupletArray = new Character[quadrupletSize];

        IntStream.range(0, quadrupletSize)
                .forEach(c -> quadrupletArray[c] = fullBoard[beginRow][beginColumn + c]);

        return Arrays.stream(quadrupletArray).allMatch(Character.valueOf('B')::equals);
    }
}
