package Win;

public class TotalPointsCounter {
    
    public static Integer countPoints(Character[][] fullBoard, Character currentStone) {
        
        Integer horizontalPoints = HorizontalCounter.countHorizontal(fullBoard, currentStone);
        Integer verticalPoints = VerticalCounter.countVertical(fullBoard, currentStone);
        
        return horizontalPoints + verticalPoints;
    }
}
