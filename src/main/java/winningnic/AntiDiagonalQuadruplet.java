package winningnic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AntiDiagonalQuadruplet extends Quadruplet {
    
    public AntiDiagonalQuadruplet(Character[][] fullBoard, Integer beginRow, Integer beginColumn) {
        super(beginRow, beginColumn);
        
        Character[] quad = new Character[] {fullBoard[beginRow][beginColumn], fullBoard[beginRow-1][beginColumn+1],
                fullBoard[beginRow-2][beginColumn+2], fullBoard[beginRow-3][beginColumn+3]};
        this.isQuadrupletValid = Arrays.stream(quad).allMatch(Character.valueOf('B')::equals);

        boolean isQuadrupletAtBeginning;
        boolean isQuadrupletAtEnd;
        
        if(beginColumn == 0 && beginRow != 3 || beginRow == 9 && beginColumn != 6) {
            isQuadrupletAtBeginning = true;
            isQuadrupletAtEnd = false;
        } else if(beginColumn == 6 && beginRow != 9 || beginRow == 3 && beginColumn != 0) {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = true;
        } else if((beginRow == 3 && beginColumn == 0) || (beginRow == 9 && beginColumn == 6)) { 
            isQuadrupletAtBeginning = true;
            isQuadrupletAtEnd = true;
        } else {
            isQuadrupletAtBeginning = false;
            isQuadrupletAtEnd = false;
        }

        if(isQuadrupletAtBeginning && !isQuadrupletAtEnd) {
            isQuadrupletCandidate =  quad[0] != fullBoard[beginRow-nextQuadrupletOffset][beginColumn+nextQuadrupletOffset];
        } else if(isQuadrupletAtEnd && !isQuadrupletAtBeginning) {
            isQuadrupletCandidate = quad[0] != fullBoard[beginRow-previousQuadrupletOffset][beginColumn+previousQuadrupletOffset];
        } else if(!isQuadrupletAtBeginning && !isQuadrupletAtEnd){
            isQuadrupletCandidate = quad[0] != fullBoard[beginRow-previousQuadrupletOffset][beginColumn+previousQuadrupletOffset]
                    && (quad[0] != fullBoard[beginRow-nextQuadrupletOffset][beginColumn+nextQuadrupletOffset]);
        } else isQuadrupletCandidate = true;
        
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
