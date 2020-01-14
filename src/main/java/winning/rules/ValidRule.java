package winning.rules;

interface ValidRule {

    final Integer quadrupletSize = 4;

    Boolean isValid(Character[][] fullboard, Integer beginRow, Integer beginColumn);

}
