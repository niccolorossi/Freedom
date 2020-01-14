package winning.rules;

interface ValidRule {

    Integer quadrupletSize = 4;
    Boolean isValid(Character[][] fullBoard, Integer beginRow, Integer beginColumn, Character currentStone);

}
