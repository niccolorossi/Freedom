package winning.limits;

public interface Limits {
    
    int QUADRUPLET_SIZE = 4;
    
    int beginRow();
    int beginCol();
    int endRowInclusive();
    int endColInclusive();
}
