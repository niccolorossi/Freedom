package winning.quadruplet;

import winning.quadruplet.Quadruplet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AntiDiagonalQuadruplet extends Quadruplet {
    
    public AntiDiagonalQuadruplet(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        super(beginRow, beginColumn);
        
        Character[] quadruplet = new Character[] {fullBoard[beginRow][beginColumn], fullBoard[beginRow-1][beginColumn+1],
                fullBoard[beginRow-2][beginColumn+2], fullBoard[beginRow-3][beginColumn+3]};
        this.isQuadrupletValid = Arrays.stream(quadruplet).allMatch(Character.valueOf('B')::equals);


        
    }
    
    @Override
    public List<List<Integer>> getIndices() {
        List<List<Integer>> toReturn = new ArrayList<>();
        for (int index = 0; index < 4; index++) {
            toReturn.add(Arrays.asList(beginRow-index, beginColumn+index));
        }
        return toReturn;
    }

}
