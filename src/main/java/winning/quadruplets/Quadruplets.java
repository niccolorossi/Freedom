package winning.quadruplets;

import game.Board;
import winning.LiveStonesBoard;

interface Quadruplets {
    
    void findQuadruplets(Board fullBoard, Character currentStone, LiveStonesBoard liveStonesBoard);
}
