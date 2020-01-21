import game.Game;
import input.InputString;
import output.OutputManager;


public class Main {
    public static void main(String[] args) {

        OutputManager outputManager = new OutputManager();
        outputManager.chooseBoardSizeMessage();
        InputString inputString = new InputString();
        Integer boardSize = inputString.getBoardSize();
        Game game = new Game(boardSize);
        game.start();
    }
}
