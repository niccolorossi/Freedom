package winningnic;

public class VerticalQuadrupletGenerator extends QuadrupletGenerator {
    
    public VerticalQuadrupletGenerator(Character[][] fullBoard) {
        super(fullBoard);
    }

    @Override
    public VerticalQuadruplet generate(Integer row, Integer column) {
        return new VerticalQuadruplet(fullBoard, row, column);
    }
}
