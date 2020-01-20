import game.Game;
import input.UserInput;


public class Main {
    public static void main(String[] args) {

        System.out.println("Choose the size of the board:");
        UserInput userInput = new UserInput();
        Integer boardSize = userInput.getBoardSize();
        Game start = new Game(boardSize);
        start.run();
    }
}
