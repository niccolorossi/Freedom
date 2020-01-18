package winning.rules;

public interface Rules {

    int PREVIOUS_QUADRUPLET_OFFSET = - 1;
    int QUADRUPLET_SIZE = 4;

    Boolean isCandidate(Character[][] fullBoard, Integer beginRow, Integer beginColumn);
    Boolean isValid(Character[][] fullBoard, Integer beginRow, Integer beginColumn, Character currentStone);

}
