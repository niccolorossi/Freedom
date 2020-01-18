package winning;

import winning.indexes.*;
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

    public List<Indexes> findAllQuadruplets(Character currentStone) {

        ArrayList<Indexes> allQuadruplets = new ArrayList<>();
        allQuadruplets.addAll(findHorizontalQuadruplets(currentStone));
        allQuadruplets.addAll(findVerticalQuadruplets(currentStone));
        allQuadruplets.addAll(findAntiDiagonalQuadruplets(currentStone));
        allQuadruplets.addAll(findDiagonalQuadruplets(currentStone));

        return allQuadruplets;

    }

    private List<HorizontalIndexes> findHorizontalQuadruplets(Character currentStone) {

        List<HorizontalIndexes> allHorizontal = horizontalQuadruplets.findQuadruplets(fullBoard, currentStone);

        return allHorizontal;
    }

    private List<VerticalIndexes> findVerticalQuadruplets(Character currentStone) {

        List<VerticalIndexes> allVertical = verticalQuadruplets.findQuadruplets(fullBoard, currentStone);

        return allVertical;
    }

    private List<DiagonalIndexes> findDiagonalQuadruplets(Character currentStone) {
        List<DiagonalIndexes> allDiagonal = diagonalQuadruplets.findQuadruplets(fullBoard, currentStone);

        return allDiagonal;

    }

    private List<AntiDiagonalIndexes> findAntiDiagonalQuadruplets(Character currentStone) {
        List<AntiDiagonalIndexes> allAntiDiagonal = antiDiagonalQuadruplets.findQuadruplets(fullBoard, currentStone);

        return allAntiDiagonal;
    }
}
