package input;

import exceptions.OutOfBoundsException;

import java.util.ArrayList;
import java.util.List;

public class ValidInputMove {
    
    private List<Integer> move;
    
    ValidInputMove(Integer boardSize, List<Integer> parsedIntegers){
        try {
            Integer row = currentRow(parsedIntegers);
            ValidateCoordinateInBounds validateRow = new ValidateCoordinateInBounds(row);
            validateRow.validate(boardSize);
            Integer column = currentColumn(parsedIntegers);
            ValidateCoordinateInBounds validateColumn = new ValidateCoordinateInBounds(column);
            validateColumn.validate(boardSize);
            move = new ArrayList<>();
            move.add(row);
            move.add(column);
        } catch(OutOfBoundsException | IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException ignore) {
            
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
