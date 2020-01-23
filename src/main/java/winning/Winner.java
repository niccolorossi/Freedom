package winning;

import game.Board;

import java.util.Arrays;
import java.util.List;

public class Winner {

    private Points whitePoints;
    private Points blackPoints;

    public Winner(Board fullBoard) {

        this.whitePoints = new Points(fullBoard, 'W');
        this.blackPoints = new Points(fullBoard, 'B');
    }

    public List<Integer> getWinner() {

        Integer whiteScore = whitePoints.getScore();
        Integer blackScore = blackPoints.getScore();

        return Arrays.asList(whiteScore, blackScore);
    }
    
    //possibly a String method that says winner is W / winner is B / game is drawn
    //responsabilità: stabilire il vincitore
    
}
