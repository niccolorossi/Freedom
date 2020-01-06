package it.freedom;

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
}
