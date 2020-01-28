package output;

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
        printStream.println("Welcome to Freedom!\nYou must enter the coordinates of the move\nseparated by whitespace.");
    }

    public void lastTurnMessage(Character playerStone) {
        printStream.println("Player " + playerStone + ", do you want to pass? Y/N");
    }

    public void currentPlayerTurnMessage(Character playerStone) {
        printStream.println("Player " + playerStone + ", it's your turn!");
    }

    public void winnerMessage(String winningMessage) {
       printStream.println(winningMessage);
    }

    public void printBoard(Board board) {
        printStream.println(new BoardAsString().parsedBoard(board));
    }

    public void freedomMessage(Boolean freedom) {
        if(freedom) {
            printStream.println("This move is freedom! You can place the stone wherever you want!");
        }
    }

    public void invalidBoardInput() {
        printStream.println("You must enter an integer number greater than or equal to 6!");
    }
    public void invalidInputFormat() {
        printStream.println("You must enter TWO numbers separated by a whitespace");
    }
    
    public void printErrorMessage(Exception e) {
        printStream.println(e.getMessage());
    }
}
