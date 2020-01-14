package winning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HorizontalQuadruplet extends Quadruplet {
    
    public HorizontalQuadruplet(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        super(beginRow, beginColumn);
        
        HorizontalValidRule hvr = new HorizontalValidRule();
        this.isQuadrupletValid = hvr.isValid(fullBoard, beginRow, beginColumn);

        boolean isQuadrupletAtBeginning;
        boolean isQuadrupletAtEnd;
        
        if(beginColumn == 0) {
            isQuadrupletAtBeginning = true;
            isQuadrupletAtEnd = false;
        } else if(beginColumn == fullBoard[0].length-quadruplet.length) {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = true;
        } else {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = false;
        }
        
        if(isQuadrupletAtBeginning) { 
            isQuadrupletCandidate =  quadruplet[0] != fullBoard[beginRow][beginColumn+nextQuadrupletOffset];
        } else if(isQuadrupletAtEnd) { 
            isQuadrupletCandidate = quadruplet[0] != fullBoard[beginRow][beginColumn+previousQuadrupletOffset];
        } else {
            isQuadrupletCandidate = quadruplet[0] != fullBoard[beginRow][beginColumn+previousQuadrupletOffset] 
                    && quadruplet[0] != fullBoard[beginRow][beginColumn+nextQuadrupletOffset];
        }
        
    }

    @Override
    public List<List<Integer>> getIndices() {
        List<List<Integer>> toReturn = new ArrayList<>();
        for(int column = beginColumn; column < beginColumn+4; column++) {
            toReturn.add(Arrays.asList(beginRow, column));
        }
        return toReturn;
    }
}
