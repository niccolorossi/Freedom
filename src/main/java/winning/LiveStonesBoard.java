package winning;

import winning.indeces.Indeces;

import java.util.List;
import java.util.stream.IntStream;

public class LiveStonesBoard {
    
    private Boolean[][] currentBoard;
    private Character currentStone;
    private PlayerQuadruplets playerQuadruplets;


    public LiveStonesBoard(Character[][] fullBoard, Character currentStone) {

        this.playerQuadruplets = new PlayerQuadruplets(fullBoard);
        this.currentStone = currentStone;

        Integer boardSize = fullBoard[0].length;

        this.currentBoard = new Boolean[boardSize][boardSize];
        IntStream.range(0, boardSize)
                .forEach(r -> IntStream.range(0, boardSize)
                        .forEach(c -> currentBoard[r][c] = false));
    }

    public void aliveStonesForCurrentPlayer() {
        List<Indeces> allDiagonals = playerQuadruplets.findAllDiagonals(currentStone);
        for (int element = 0; element < allDiagonals.size(); element ++){
            updateLiveStones(allDiagonals.get(element));
        }
    }

    public Boolean[][] getCurrentBoard() {
        return currentBoard;
    }
    
    private void updateLiveStones(Indeces indeces) {
        List<List<Integer>> indicesList = indeces.getIndices();
        for(int i=0; i<4; i++) {
            List<Integer> thisCell = indicesList.get(i);
            Integer row = thisCell.get(0);
            Integer column = thisCell.get(1);
            currentBoard[row][column] = true;
        }
    }
}
