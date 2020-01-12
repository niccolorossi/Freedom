package winningnic;

abstract class QuadrupletGenerator {

    Character[][] fullBoard;

    public QuadrupletGenerator(Character[][] fullBoard) {
        this.fullBoard = fullBoard;
    }
    
    abstract public Quadruplet generate(Integer row, Integer column);
}
