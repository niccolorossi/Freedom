package winning.rules;

import game.Board;

public interface Rules {

    int PREVIOUS_QUADRUPLET_OFFSET = - 1;
    int QUADRUPLET_SIZE = 4;

    Boolean isCandidate(Board fullBoard, Integer beginRow, Integer beginColumn);
    Boolean isValid(Board fullBoard, Integer beginRow, Integer beginColumn, Character currentStone);

}
