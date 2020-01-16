package input;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class IntegerParser {
    
    private List<Integer> parsedIntegers;
    
    IntegerParser(String inputString) {
        try {
            this.parsedIntegers = Stream.of(inputString.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
    
    List<Integer> getParsedIntegers() {
        return parsedIntegers;
    }
    
}
