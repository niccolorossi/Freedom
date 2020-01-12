package winningnic;

public class DiagonalQuadrupletGenerator extends QuadrupletGenerator {

    public DiagonalQuadrupletGenerator(Character[][] fullBoard) {
        super(fullBoard);
    }
    
    @Override
    public DiagonalQuadruplet generate(Integer row, Integer column) {
        return new DiagonalQuadruplet(fullBoard, row, column);
    }
}
