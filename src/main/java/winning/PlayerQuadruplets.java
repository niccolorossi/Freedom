package winning;

import winning.indeces.AntiDiagonalIndeces;
import winning.indeces.DiagonalIndeces;
import winning.indeces.HorizontalIndeces;
import winning.indeces.VerticalIndeces;
import winning.quadruplets.AntiDiagonalQuadruplets;
import winning.quadruplets.DiagonalQuadruplets;
import winning.quadruplets.HorizontalQuadruplets;
import winning.quadruplets.VerticalQuadruplets;

import java.util.List;

public class PlayerQuadruplets {
    
    private LiveStonesBoard liveStonesBoard;
    private Character[][] fullBoard;
    private Character currentStone;
    private Boolean[][] currentPlayerStonesAlive;

    private HorizontalQuadruplets horizontalQuadruplets;
    private VerticalQuadruplets verticalQuadruplets;
    private DiagonalQuadruplets diagonalQuadruplets;
    private AntiDiagonalQuadruplets antiDiagonalQuadruplets;

    public PlayerQuadruplets(LiveStonesBoard liveStonesBoard, Character[][] fullBoard, Character currentStone) {

        this.liveStonesBoard = liveStonesBoard;
        this.fullBoard = fullBoard;
        this.currentStone = currentStone;
        this.horizontalQuadruplets = new HorizontalQuadruplets(fullBoard);
        this.verticalQuadruplets = new VerticalQuadruplets(fullBoard);
        this.diagonalQuadruplets = new DiagonalQuadruplets(fullBoard);
        this.antiDiagonalQuadruplets = new AntiDiagonalQuadruplets(fullBoard);

    }

    public void findHorizontalQuadruplets() {

        List<HorizontalIndeces> allHorizontal = horizontalQuadruplets.findQuadruplets(fullBoard, currentStone);

        for(int quadruplet = 0; quadruplet < allHorizontal.size(); quadruplet ++) {
            liveStonesBoard.updateLiveStones(allHorizontal.get(quadruplet));
        }


    }
    
    public void findVerticalQuadruplets() {

        List<VerticalIndeces> allVertical = verticalQuadruplets.findQuadruplets(fullBoard, currentStone);

        for(int quadruplet = 0; quadruplet < allVertical.size(); quadruplet ++) {
            liveStonesBoard.updateLiveStones(allVertical.get(quadruplet));
        }
    }

    public void findDiagonalQuadruplets() {
        List<DiagonalIndeces> allDiagonal = diagonalQuadruplets.findQuadruplets(fullBoard, currentStone);

        for(int quadruplet = 0; quadruplet < allDiagonal.size(); quadruplet ++) {
            liveStonesBoard.updateLiveStones(allDiagonal.get(quadruplet));
        }

    }

    public void findAntiDiagonalQuadruplets() {
        List<AntiDiagonalIndeces> allAntiDiagonal = antiDiagonalQuadruplets.findQuadruplets(fullBoard, currentStone);

        for (int quadruplet = 0; quadruplet < allAntiDiagonal.size(); quadruplet++) {
            liveStonesBoard.updateLiveStones(allAntiDiagonal.get(quadruplet));
        }
    }
}
