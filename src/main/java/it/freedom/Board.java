package it.freedom;

import it.freedom.exceptions.OutOfBoundsException;

class Board {
    
    private Character[][] currentBoard;
    private int boardSize;
    private char EMPTY = '_';

    Board(int boardSize) {

        this.boardSize = boardSize;
        this.currentBoard = new Character[boardSize][boardSize];

        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                currentBoard[i][j] = EMPTY;
            }
        }
        
    }
    
    String printBoard() {

        String result = "";

        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                if(j == 0){
                    result += "|";
                }
                result += currentBoard[i][j] + "|";
            }

            if(i != this.boardSize - 1){
                result += "\n";
            }
        }

        return result;
    }

    private void checkBounds(int coordinate) throws OutOfBoundsException {
        if(coordinate < 0 || coordinate > 9)
            throw new OutOfBoundsException(coordinate + " is out of bound!");
    }

    void setStone(Character symbol, int  x, int y) {
        try {
            
            checkBounds(x);
            checkBounds(y);
            currentBoard[x-1][y-1] = symbol;

        } catch (OutOfBoundsException e1) {
            System.out.println(e1.getMessage());
        
        } 
        
    }
}
