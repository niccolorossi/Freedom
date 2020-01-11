package winning;

import winning.quadruplets.QuadrupletsCounter;

public class RowLive {

    private Integer[][] counter;

    public RowLive(Character[][] fullBoard, Character currentStone) {

        Integer size = fullBoard[0].length;
        this.counter = new Integer[size][size];

        for(int i = 0; i < size; i++) {
            Character[] currentRow = fullBoard[i];
            Integer[] stones = QuadrupletsCounter.setAliveStonesInArray(currentRow, currentStone);
            for (int j = 0; j < size; j++){
                counter[i][j] = stones[j];
            }
        }
    }

    public Integer[][] getCounter() {

        return counter;
    }
}
