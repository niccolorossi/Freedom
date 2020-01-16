package winning;

import winning.indeces.*;
import winning.quadruplets.AntiDiagonalQuadruplets;
import winning.quadruplets.DiagonalQuadruplets;
import winning.quadruplets.HorizontalQuadruplets;
import winning.quadruplets.VerticalQuadruplets;

import java.util.ArrayList;
import java.util.List;

public class PlayerQuadruplets {
    

    private Character[][] fullBoard;
    private HorizontalQuadruplets horizontalQuadruplets;
    private VerticalQuadruplets verticalQuadruplets;
    private DiagonalQuadruplets diagonalQuadruplets;
    private AntiDiagonalQuadruplets antiDiagonalQuadruplets;

    public PlayerQuadruplets(Character[][] fullBoard) {

        this.fullBoard = fullBoard;
        this.horizontalQuadruplets = new HorizontalQuadruplets(fullBoard);
        this.verticalQuadruplets = new VerticalQuadruplets(fullBoard);
        this.diagonalQuadruplets = new DiagonalQuadruplets(fullBoard);
        this.antiDiagonalQuadruplets = new AntiDiagonalQuadruplets(fullBoard);

    }

    public List<Indeces> findAllDiagonals(Character currentStone) {

        ArrayList<Indeces> allDiagonals = new ArrayList<>();
        allDiagonals.addAll(findHorizontalQuadruplets(currentStone));
        allDiagonals.addAll(findVerticalQuadruplets(currentStone));
        allDiagonals.addAll(findAntiDiagonalQuadruplets(currentStone));
        allDiagonals.addAll(findDiagonalQuadruplets(currentStone));

        return allDiagonals;

    }

    public List<HorizontalIndeces> findHorizontalQuadruplets(Character currentStone) {

        List<HorizontalIndeces> allHorizontal = horizontalQuadruplets.findQuadruplets(fullBoard, currentStone);

        return allHorizontal;
    }
    
    public List<VerticalIndeces> findVerticalQuadruplets(Character currentStone) {

        List<VerticalIndeces> allVertical = verticalQuadruplets.findQuadruplets(fullBoard, currentStone);

        return allVertical;
    }

    public List<DiagonalIndeces> findDiagonalQuadruplets(Character currentStone) {
        List<DiagonalIndeces> allDiagonal = diagonalQuadruplets.findQuadruplets(fullBoard, currentStone);

        return allDiagonal;

    }

    public List<AntiDiagonalIndeces> findAntiDiagonalQuadruplets(Character currentStone) {
        List<AntiDiagonalIndeces> allAntiDiagonal = antiDiagonalQuadruplets.findQuadruplets(fullBoard, currentStone);

        return allAntiDiagonal;
    }
}
