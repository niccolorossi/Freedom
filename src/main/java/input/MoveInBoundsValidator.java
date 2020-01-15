package input;

import exceptions.OutOfBoundsException;

import java.util.List;

public class MoveInBoundsValidator {
    
    private List<Integer> move;
    
    MoveInBoundsValidator(List<Integer> move){
        this.move = move;
    }
    
    private Integer getRow() {
        return move.get(0);
    }
    
    private Integer getColumn() {
        return move.get(1);
    }
    
    void validateMove(Integer boardSize) {
        try {
            Integer row = this.getRow();
            ValidateCoordinate validateRow = new ValidateCoordinate(row);
            validateRow.validate(boardSize);
            Integer column = this.getColumn();
            ValidateCoordinate validateColumn = new ValidateCoordinate(column);
            validateColumn.validate(boardSize);
        } catch(OutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
