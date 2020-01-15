package input;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class IntegerParser {
    
    private String inputString;
    
    IntegerParser(String inputString) {
        this.inputString = inputString;
    }
    
    List<Integer> getParsedIntegers() {
        try {
            List<Integer> toReturn = Stream.of(inputString.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            return toReturn;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
    
}
