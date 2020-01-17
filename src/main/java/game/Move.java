package game;

abstract public class Move {
    
    Character newStone;
    Integer row;
    Integer column;
    
    void setMove(Board board) {
        try {
            board.placeStone(newStone, row, column);
        } catch (NullPointerException e) {
        }
    }
    
}
