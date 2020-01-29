package winning;

import game.Board;

public class Winner {

    private Points whitePoints;
    private Points blackPoints;

    public Winner(Board fullBoard) {

        this.whitePoints = new Points(fullBoard, 'W');
        this.blackPoints = new Points(fullBoard, 'B');
    }

    public String getWinner() {

        Integer whiteScore = whitePoints.getScore();
        Integer blackScore = blackPoints.getScore();

        StringBuilder str = new StringBuilder();
        str.append(whiteScore).append(" - ").append(blackScore);
        String comment;

        if(whiteScore.equals(blackScore)) {
            comment = " : the game is drawn!";
        } else {
            comment = whiteScore > blackScore ? " : White won!" : " : Black won!";
        }
        str.append(comment);
        
        return str.toString();
    }
    
}
