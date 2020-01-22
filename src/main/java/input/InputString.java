package input;

import exceptions.BoardTooSmallException;
import exceptions.OutOfBoundsException;
import exceptions.WrongPassMessageException;
import output.OutputManager;

import java.util.List;
import java.util.Scanner;

public class InputString {

    private String inputString;
    private Scanner scanner;

    public InputString(String inputString) {

        this.inputString = inputString;

    }

    public InputString() {
        this.scanner = new Scanner(System.in);
    }
    
    public List<Integer> getMove(Integer boardSize) {
        
        while(true) {
            try {

                String inputString =  scanner.nextLine();
                StringToIntegerList stringToIntegerList = new StringToIntegerList(inputString);
                List<Integer> moveList = stringToIntegerList.integerList();
                ValidInputMove validInputMove = new ValidInputMove(boardSize, moveList);
                return validInputMove.inputMove();
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                OutputManager outputManager = new OutputManager();
                outputManager.invalidInputFormat(e);
            } catch (OutOfBoundsException e) {
                OutputManager outputManager = new OutputManager();
                outputManager.outOfBounds(e);
            }
        }
    }
    
    public Integer getBoardSize() {
        
        while(true) {
            try {
                String inputString = scanner.nextLine();
                Integer inputInteger = Integer.parseInt(inputString);
                ValidBoardSize validBoardSize = new ValidBoardSize(inputInteger);
                return validBoardSize.boardSize();
            } catch ( NumberFormatException e) {
                OutputManager outputManager = new OutputManager();
                outputManager.invalidBoardInput(e);
            } catch (BoardTooSmallException e) {
                OutputManager outputManager = new OutputManager();
                outputManager.boardTooSmall(e);
            }
        }
    }

    public Boolean notPassedTurn() {
        
        while(true) {
            try {
                String inputString = scanner.nextLine();
                ValidPassMessage validPassMessage = new ValidPassMessage(inputString);
                return validPassMessage.passMessage().equals("N");
            } catch (WrongPassMessageException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
