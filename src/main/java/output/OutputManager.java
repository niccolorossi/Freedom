package output;

import exceptions.OutOfBoundsException;
import game.Board;

import java.io.PrintStream;

public class OutputManager {

    private PrintStream printStream;

    public OutputManager() {
        this.printStream = new PrintStream(System.out);
    }

    public void chooseBoardSizeMessage() {
        printStream.println("Choose the size of the board:");
    }

    public void greetingsMessage() {
        printStream.println("Welcome to Freedom!\n You must enter the coordinate of the move\n separated by whitespace.");
    }

    public void lastTurnMessage(Character playerStone) {
        printStream.println("Player " + playerStone + ", do you want to pass? Y/N");
    }

    public void changeTurnMessage(Character playerStone) {
        printStream.println("Player " + playerStone + ", it's your turn!");
    }

    public void displayMessage(String message) {
        printStream.println(message);
    }

    public void printBoard(Board board) {
        printStream.println(new BoardAsString().parsedBoard(board));
    }

    public void freedomMessage() {
        printStream.println("Next move is freedom!");
    }

    public void invalidInputFormat(Exception e) {
        printStream.println("You must enter TWO numbers separated by a whitespace");
    }

    public void outOfBounds(OutOfBoundsException e) {
        printStream.println(e.getMessage());
    }
}
