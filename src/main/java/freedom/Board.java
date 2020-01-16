package freedom;

import java.util.stream.IntStream;

class Board {
    
    private Character[][] currentBoard;
    private char emptyCellCharacter = '_';
    

    Board(int boardSize) {

        this.currentBoard = new Character[boardSize][boardSize];
        IntStream.range(0, boardSize)
                .forEach(r -> IntStream.range(0, boardSize)
                        .forEach(c -> currentBoard[r][c] = emptyCellCharacter));
    }
    
    Character[][] getCurrentBoard() {

        return this.currentBoard;
    }
    
    Character getStone(Integer row, Integer column) {

        return currentBoard[row-1][column-1];
    }
    
    void setStone(Character symbol, int row, int column) {

        currentBoard[row-1][column-1] = symbol;
    }

    Character getEmptyCellCharacter() {

        return emptyCellCharacter;
    }
    
    Integer getBoardSize(){return currentBoard[0].length;}
    
}
