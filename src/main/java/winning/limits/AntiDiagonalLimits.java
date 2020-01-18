package winning.limits;

import winning.rules.Rules;

public class AntiDiagonalLimits {
    
    

    private Integer boardSize;
    public AntiDiagonalLimits(Integer length) {
        this.boardSize = length;
    }

    public Integer beginRowOfLowermostAntiDiagonalQuadruplets() {
        return boardSize + Rules.PREVIOUS_QUADRUPLET_OFFSET;
    }

    public Integer beginColOfLowermostAntiDiagonalQuadruplets(){
        return 0;
    }

    public Integer beginRowOfUppermostAntiDiagonalQuadruplets() {
        return Rules.QUADRUPLET_SIZE + Rules.PREVIOUS_QUADRUPLET_OFFSET;
    }
    public Integer beginColOfUppermostAntiDiagonalQuadruplets() {
        return boardSize - Rules.QUADRUPLET_SIZE;
    }
}
