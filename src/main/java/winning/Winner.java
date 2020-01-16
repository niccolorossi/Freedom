package winning;

public class Winner {

    private Points pc;

    public Winner(Character[][] fullBoard) {

        this.pc = new Points(fullBoard);
    }

    public String getWinner() {

        Integer whitePoints = pc.getWhitePoints();
        Integer blackPoints = pc.getBlackPoints();

        StringBuilder str = new StringBuilder();
        str.append(whitePoints + " - " + blackPoints);
        String comment;

        if(whitePoints == blackPoints) {
            comment = " : the game is drawn!";
        } else {
            comment = whitePoints > blackPoints ? " : White won!" : " : Black won!";
        }
        str.append(comment);

        return str.toString();
    }
}
