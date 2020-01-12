package winningnic;

public class HorizontalQuadrupletsGenerator {
    
    Character[][] fullBoard;
    
    public HorizontalQuadrupletsGenerator(Character[][] fullBoard) {
        this.fullBoard = fullBoard;
    } 
    
    public HorizontalQuadruplet generate(Integer row, Integer column) {
        return new HorizontalQuadruplet(fullBoard, row, column);
    }
     
}
