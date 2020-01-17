package game;

import java.util.Arrays;
import java.util.List;

public class LastMove extends Move {
    
    Character newStone;
    
    public LastMove(Character newStone) {
        this.newStone = newStone;
    }
    
    @Override
    void setMove(Board board) {
        Character[][] currentBoard = board.currentBoard();
        Character emptyCellCharacter = board.emptyCellCharacter();
        Integer boardSize = board.size();
        
        for(int row=0; row<boardSize; row++) {
            for(int col=0; col<boardSize; col++) {
                if(currentBoard[row][col].equals(emptyCellCharacter)) {
                    board.placeStone(newStone, row+1, col+1);
                }
            }
        }
    }
}
