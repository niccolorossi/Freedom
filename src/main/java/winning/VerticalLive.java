package winning;

import winning.quadruplets.QuadrupletsCounter;

public class VerticalLive {

    private Integer[][] counter;

    public VerticalLive(Character[][] fullBoard, Character currentStone) {

        Transposer trans = new Transposer(fullBoard);

        Integer size = fullBoard[0].length;

        this.counter = new Integer[size][size];

        for(int i = 0; i < size; i++) {
            Character[] currentRow =  trans.getCharTranspose()[i];
            Integer[] stones = QuadrupletsCounter.setAliveStonesInArray(currentRow, currentStone);
            for (int j = 0; j < size; j++){
                counter[i][j] = stones[j];
            }
        }

        Transposer last_trans = new Transposer(counter);
        counter = last_trans.getIntTranspose();
    }


    public Integer[][] getCounter() {
        return counter;
    }
}
