package it.freedom;

import java.util.StringJoiner;

class BoardPrinter {
    
    static String boardPrinter(Board board) {
        
        Character[][] currentBoard = board.getCurrentBoard();
        Integer boardSize = board.getBoardSize();
        
        StringJoiner toReturn = new StringJoiner("\n");
        for(int row=0; row<boardSize; row++) {
            StringJoiner rowString = new StringJoiner("|");
            for(int column=0; column<boardSize; column++) {
                rowString.add(String.valueOf(currentBoard[row][column]));
            }
            toReturn.add(rowString.toString());
        }
        return toReturn.toString();
    }
    
}
