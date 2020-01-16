package input;

import exceptions.OutOfBoundsException;

import java.util.ArrayList;
import java.util.List;

public class MoveInBoundsValidator {
    
    private List<Integer> move;
    
    MoveInBoundsValidator(Integer boardSize, List<Integer> parsedIntegers){
        try {
            Integer row = getRow(parsedIntegers);
            ValidateCoordinate validateRow = new ValidateCoordinate(row);
            validateRow.validate(boardSize);
            Integer column = getColumn(parsedIntegers);
            ValidateCoordinate validateColumn = new ValidateCoordinate(column);
            validateColumn.validate(boardSize);
            move = new ArrayList<>();
            move.add(row);
            move.add(column);
        } catch(OutOfBoundsException | NullPointerException | IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private Integer getRow(List<Integer> parsedInteger) {
        return parsedInteger.get(0);
    }

    private Integer getColumn(List<Integer> parsedInteger) {
        return parsedInteger.get(1);
    }
    
    List<Integer> getMove() {
        return this.move;
    }
}
