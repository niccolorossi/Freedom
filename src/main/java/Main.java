import exceptions.BoardTooSmall;
import game.Game;
import input.UserInput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Choose the size of the board:");
        while(true) {
            try {
                Scanner in = new Scanner(System.in);
                String inputString = in.nextLine();
                UserInput userInput = new UserInput(inputString);
                Integer boardSize = userInput.getBoardSize();
                Game start = new Game(boardSize);
                start.run();
                break;
            } catch (BoardTooSmall e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
