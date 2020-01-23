import game.Game;
import input.InputString;
import output.OutputManager;


public class Main {
    public static void main(String[] args) {

        initMessages();
        Integer boardSize = askForBoardSize();
        initGame(boardSize);
    }

    private static void initMessages(){
        OutputManager outputManager = new OutputManager();
        outputManager.greetingsMessage();
        outputManager.chooseBoardSizeMessage();
    }

    private static Integer askForBoardSize() {
        InputString inputString = new InputString();
        return inputString.getBoardSize();
    }

    private static void initGame(Integer boardSize) {
        Game game = new Game(boardSize);
        game.start();
    }
}
