package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class LastMove extends Move {
    
    LastMove(Character newStone, Board board) {
        this.currentPlayer = newStone;
        this.coordinates = findCoordinates(board);
    }
    
    private List<Integer> findCoordinates(Board board) {
        Character[][] currentBoard = board.currentBoard();
        Character emptyCellCharacter = board.emptyCellCharacter();
        Integer boardSize = board.size();
        List<Integer> toReturn = new ArrayList<>();
        
        for(int row=0; row<boardSize; row++) {
            for(int col=0; col<boardSize; col++) {
                if(currentBoard[row][col].equals(emptyCellCharacter)) {
                    toReturn.add(row);
                    toReturn.add(col);
                }
            }
        }

        return toReturn;
    }
}
