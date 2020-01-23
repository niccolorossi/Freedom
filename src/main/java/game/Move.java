package game;

import java.util.List;

abstract public class Move {
    
    Character currentPlayer;
    List<Integer> coordinates;

    public Character currentPlayer() {
        return currentPlayer;
    }
    
    public Integer getRow() {
        return coordinates.get(0);
    }
    
    public Integer getColumn() {
        return coordinates.get(1);
    }
    
}
