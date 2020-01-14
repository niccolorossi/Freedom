package winning.rules;

public interface Rules {

    int PREVIOUS_QUADRUPLET_OFFSET = - 1;
    int QUADRUPLET_SIZE = 4;
    int FIRST_INDEX = 0;
    Boolean isCandidate(Character[][] fullBoard, Integer beginRow, Integer beginColumn);
    Boolean isValid(Character[][] fullBoard, Integer beginRow, Integer beginColumn, Character currentStone);

}
