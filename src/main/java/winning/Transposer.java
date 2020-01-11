package winning;

public class Transposer {

    private Integer[][] intTranspose;
    private Character[][] charTranspose;

    public Transposer(Character[][] fullBoard) {

        Integer size = fullBoard[0].length;

        charTranspose = new Character[size][size];

        for(int row = 0;  row < size; row++){
            for(int col = 0; col < size; col++){
                charTranspose[row][col] = fullBoard[col][row];
            }
        }
    }

    public Transposer(Integer[][] fullBoard) {

        Integer size = fullBoard[0].length;

        intTranspose = new Integer[size][size];

        for(int row = 0;  row < size; row++){
            for(int col = 0; col < size; col++){
               intTranspose[row][col] = fullBoard[col][row];
            }
        }
    }

    public Character[][] getCharTranspose() {
        return charTranspose;
    }

    public Integer[][] getIntTranspose() {
        return intTranspose;
    }
}

