package checkers;

public class CloseCellsFinder {
    
    public static Integer getLowerLimit(Integer coordinate) {
        if(coordinate == 1) {
            return coordinate;
        } else return coordinate-1;
    }
    
    public static Integer getUpperLimit(Integer coordinate) {
        if(coordinate == 10) {
            return coordinate;
        } else return coordinate+1;
    }
    
}
