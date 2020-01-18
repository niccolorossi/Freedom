package winning.quadruplets;


import winning.indexes.HorizontalIndexes;
import winning.limits.HorizontalLimits;
import winning.rules.HorizontalRules;

import java.util.ArrayList;
import java.util.List;

public class HorizontalQuadruplets {

    private HorizontalLimits horizontalLimits;
    private HorizontalRules horizontalRules;


    public HorizontalQuadruplets(Character[][] fullBoard){
        this.horizontalLimits = new HorizontalLimits(fullBoard[0].length);
        this.horizontalRules = new HorizontalRules(horizontalLimits.beginColOfLeftmostHorizontalQuadruplets(),
                                                    horizontalLimits.beginColOfRightmostHorizontalQuadruplets());
    }

    public List<HorizontalIndexes> findQuadruplets(Character[][] fullBoard, Character currentStone) {

        Integer boardSize = fullBoard[0].length;
        Integer beginColOfLeftmostHorizontalQuadruplets = horizontalLimits.beginColOfLeftmostHorizontalQuadruplets();
        Integer beginColOfRightmostHorizontalQuadruplets = horizontalLimits.beginColOfRightmostHorizontalQuadruplets();

        ArrayList<HorizontalIndexes> horizontalQuadruplets = new ArrayList<>();

        for(int row=0; row<boardSize; row++) {

            for(int col=beginColOfLeftmostHorizontalQuadruplets; col<= beginColOfRightmostHorizontalQuadruplets; col++) {

                if(horizontalRules.isValid(fullBoard, row, col, currentStone)
                        && horizontalRules.isCandidate(fullBoard, row, col)) {

                    horizontalQuadruplets.add(new HorizontalIndexes(row,col));
                }
            }

        }

        return horizontalQuadruplets;


    }
}
