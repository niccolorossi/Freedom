package winning;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AntiDiagonalValidRule implements ValidRule {

    @Override
    public Boolean isValid(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {

        Character[] quadrupletArray = new Character[quadrupletSize];

        IntStream.range(0, quadrupletSize)
                .forEach(r -> quadrupletArray[r] = fullBoard[beginRow - r][beginColumn + r]);

        return Arrays.stream(quadrupletArray).allMatch(Character.valueOf('B')::equals);
    }
}