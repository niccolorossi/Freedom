package winning.rules;


public interface CandidateRule {
    
    Integer previousQuadrupletOffset = - 1;
    Integer firstIndex = 0;
    Boolean isCandidate(Character[][] fullBoard, Integer beginRow, Integer beginColumn);

}
