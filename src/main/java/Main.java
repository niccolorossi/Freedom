import game.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Choose the size of the board:");
        Scanner scanner = new Scanner(System.in);
        Integer boardSize = scanner.nextInt();
        Game start = new Game(boardSize);
        start.run();
    }
}
