package winning;

import game.Board;
import winning.indexes.Indexes;

import java.util.List;
import java.util.stream.IntStream;

public class LiveStonesBoard {
    
    private Boolean[][] currentBoard;
    private Character currentStone;
    private PlayerQuadruplets playerQuadruplets;

    public LiveStonesBoard(Board fullBoard, Character currentStone) {

        this.playerQuadruplets = new PlayerQuadruplets(fullBoard);
        this.currentStone = currentStone;

        Integer boardSize = fullBoard.size();

        this.currentBoard = new Boolean[boardSize][boardSize];
        IntStream.range(0, boardSize)
                .forEach(r -> IntStream.range(0, boardSize)
                        .forEach(c -> currentBoard[r][c] = false));
    }

    public void aliveStonesForCurrentPlayer() {

        List<Indexes> allQuadruplets = playerQuadruplets.findAllQuadruplets(currentStone);
        for (int element = 0; element < allQuadruplets.size(); element ++){
            updateLiveStones(allQuadruplets.get(element));
        }
    }

    public Boolean[][] getCurrentBoard() {
        return currentBoard;
    }
    
    private void updateLiveStones(Indexes indexes) {

        List<List<Integer>> indexesList = indexes.getIndexes();
        for(int i=0; i<4; i++) {
            List<Integer> thisCell = indexesList.get(i);
            Integer row = thisCell.get(0);
            Integer column = thisCell.get(1);
            currentBoard[row][column] = true;
        }
    }

    public int size() {
        return currentBoard[0].length;
    }
}
