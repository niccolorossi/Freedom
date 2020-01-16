package input;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class MoveCoordinates {
    
    private List<Integer> parsedIntegers;
    
    MoveCoordinates(String inputString) {
        try {
            this.parsedIntegers = Stream.of(inputString.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
    
    List<Integer> currentMove() {
        return parsedIntegers;
    }
    
}
