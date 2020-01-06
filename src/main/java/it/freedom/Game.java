package it.freedom;

public class Game {
    private Character[][] board;
    private int size;

    public Game(int size) {

        this.size = size;
        this.board = new Character[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                board[i][j] = '_';
            }
        }
    }

    @Override
    public String toString(){
        String result = "";

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(j == 0){
                    result += "|";
                }
                result += board[i][j] + "|";
            }

            if(i != this.size - 1){
                result += "\n";
            }
        }


        /**
        for (int i = 0; i < this.size; i++){
            for (int j = 0; j < this.size; j++){

                if (j == 0){
                    result+= "|";
                }
                result += "|";//this.board[i][j].toString() + "|";
            }
            if(i != this.size - 1){
                result += "\n";
            }
        }
    */
        return result;
    }


}
