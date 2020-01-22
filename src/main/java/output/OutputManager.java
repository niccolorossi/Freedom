package output;

import exceptions.BoardTooSmallException;
import exceptions.OutOfBoundsException;
import game.Board;

import java.io.PrintStream;
import java.util.List;

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

    public void winnerMessage(List<Integer> points) {

        Integer whitePoints = points.get(0);
        Integer blackPoints = points.get(1);

        StringBuilder str = new StringBuilder();
        str.append(whitePoints + " - " + blackPoints);
        String comment;

        if(whitePoints == blackPoints) {
            comment = " : the game is drawn!";
        } else {
            comment = whitePoints > blackPoints ? " : White won!" : " : Black won!";
        }
        str.append(comment);

       printStream.println(str.toString());
    }
    public void displayMessage(String message) {
        printStream.println(message);
    }

    public void printBoard(Board board) {
        printStream.println(new BoardAsString().parsedBoard(board));
    }

    public void freedomMessage(Boolean freedom) {
        if(freedom) {
            printStream.println("This move is freedom! You can place the stone wherever you want!");
        }
    }

    public void invalidBoardInput(Exception e) {
        printStream.println("You must enter an integer number greater than 5!");
    }
    public void invalidInputFormat(Exception e) {
        printStream.println("You must enter TWO numbers separated by a whitespace");
    }

    public void outOfBounds(OutOfBoundsException e) {
        printStream.println(e.getMessage());
    }

    public void boardTooSmall(BoardTooSmallException e) {
        printStream.println(e.getMessage());
    }
}
