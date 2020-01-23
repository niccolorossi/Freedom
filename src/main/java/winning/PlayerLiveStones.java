package winning;

import game.Board;

class PlayerLiveStones {
    
    private LiveStonesBoard liveStonesBoard;
    private PlayerQuadruplets playerQuadruplets;
    
    PlayerLiveStones(Board fullBoard, Character playerCharacter) {
        this.liveStonesBoard = new LiveStonesBoard(fullBoard, playerCharacter);
        this.playerQuadruplets = new PlayerQuadruplets(fullBoard, playerCharacter, liveStonesBoard);
    }
    
    void setAllPlayerLiveStones() {
        playerQuadruplets.findAllQuadruplets();
    }
    
    LiveStonesBoard getLiveStonesBoard() {
        return this.liveStonesBoard;
    }
    
}
