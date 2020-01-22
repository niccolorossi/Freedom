package game;

import java.util.List;

public class RegularMove extends Move {
    
    public RegularMove(List<Integer> coordinates, Character newStone){
        this.coordinates = coordinates;
        this.newStone = newStone;
    }
}
