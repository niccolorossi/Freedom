import game.Game;
import input.InputString;
import input.UserInput;


public class Main {
    public static void main(String[] args) {

        System.out.println("Choose the size of the board:");
        UserInput userInput = new UserInput();
        InputString inputString = new InputString(userInput.inputString());
        Integer boardSize = inputString.getBoardSize();
        Game start = new Game(boardSize);
        start.run();
    }
}
