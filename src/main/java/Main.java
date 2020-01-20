import game.Game;
import input.InputString;


public class Main {
    public static void main(String[] args) {

        System.out.println("Choose the size of the board:");
        InputString inputString = new InputString();
        Integer boardSize = inputString.getBoardSize();
        Game game = new Game(boardSize);
        game.start();
    }
}
