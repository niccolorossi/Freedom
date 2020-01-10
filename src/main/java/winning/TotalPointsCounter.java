package winning;

import javafx.beans.property.BooleanProperty;
import winning.straight.HorizontalCounter;
import winning.straight.VerticalCounter;

public class TotalPointsCounter {
    
    
    public static Integer countPoints(Character[][] fullBoard, Character currentStone) {
        
        Integer horizontalPoints = HorizontalCounter.countHorizontal(fullBoard, currentStone);
        Integer verticalPoints = VerticalCounter.countVertical(fullBoard, currentStone);
        
        return horizontalPoints + verticalPoints;
    }
}
