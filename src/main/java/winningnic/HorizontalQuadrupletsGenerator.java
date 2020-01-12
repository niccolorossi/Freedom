package winningnic;

public class HorizontalQuadrupletsGenerator extends QuadrupletGenerator {
    
    public HorizontalQuadrupletsGenerator(Character[][] fullBoard) {
        super(fullBoard);
    } 
    
    @Override
    public HorizontalQuadruplet generate(Integer row, Integer column) {
        return new HorizontalQuadruplet(fullBoard, row, column);
    }
}
