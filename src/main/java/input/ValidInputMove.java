package input;

import exceptions.OutOfBoundsException;

import java.util.ArrayList;
import java.util.List;

public class ValidInputMove {
    
    private List<Integer> move;
    
    ValidInputMove(Integer boardSize, List<Integer> parsedIntegers){
        try {
            Integer row = currentRow(parsedIntegers);
            ValidateCoordinate validateRow = new ValidateCoordinate(row);
            validateRow.validate(boardSize);
            Integer column = currentColumn(parsedIntegers);
            ValidateCoordinate validateColumn = new ValidateCoordinate(column);
            validateColumn.validate(boardSize);
            move = new ArrayList<>();
            move.add(row);
            move.add(column);
        } catch(OutOfBoundsException | NullPointerException | IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private Integer currentRow(List<Integer> parsedInteger) {
        return parsedInteger.get(0);
    }

    private Integer currentColumn(List<Integer> parsedInteger) {
        return parsedInteger.get(1);
    }
    
    List<Integer> currentMove() {
        return this.move;
    }
}
