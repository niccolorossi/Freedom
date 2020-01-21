package game;

import java.util.List;

abstract public class Move {
    
    Character newStone;
    List<Integer> coordinates;
    
    void setMove(Board board) {
            board.placeStone(newStone, coordinates);
    }
    
    Integer getRow() {
        return coordinates.get(0);
    }
    
    Integer getColumn() {
        return coordinates.get(1);
    }
    
}
