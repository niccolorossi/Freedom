package input;

import exceptions.BoardTooSmallException;
import exceptions.OutOfBoundsException;
import exceptions.WrongPassMessageException;
import output.OutputManager;

import java.util.List;
import java.util.Scanner;

public class InputString {

    private Scanner scanner;
    
    public InputString() {
        this.scanner = new Scanner(System.in);
    }
    
    public List<Integer> getMove(Integer boardSize) {
        
        while(true) {
            try {
                return askForMoveAndValidateIt(boardSize);
            } catch (IndexOutOfBoundsException | NumberFormatException e1) {
                printInvalidMoveInputFormatMessage();
            } catch (OutOfBoundsException e2) {
                printErrorMessage(e2);
            }
        }
    }

    private List<Integer> askForMoveAndValidateIt(Integer boardSize) throws OutOfBoundsException {
        String inputString =  scanner.nextLine();
        StringToIntegerList stringToIntegerList = new StringToIntegerList(inputString);
        List<Integer> moveList = stringToIntegerList.integerList();
        ValidInputMove validInputMove = new ValidInputMove(boardSize, moveList);
        return validInputMove.inputMove();
    }

    private void printInvalidMoveInputFormatMessage() {
        OutputManager outputManager = new OutputManager();
        outputManager.invalidInputFormat();
    }
    
    public Integer getBoardSize() {
        
        while(true) {
            try {
                return askForBoardSizeAndValidateIt();
            } catch (NumberFormatException e) {
                printInvalidBoardSizeInputMessage();
            } catch (BoardTooSmallException e) {
                printErrorMessage(e);
            }
        }
    }

    private Integer askForBoardSizeAndValidateIt() throws BoardTooSmallException, NumberFormatException {
        String inputString = scanner.nextLine();
        Integer inputInteger = Integer.parseInt(inputString);
        ValidBoardSize validBoardSize = new ValidBoardSize(inputInteger);
        return validBoardSize.boardSize();
    }

    private void printInvalidBoardSizeInputMessage() {
        OutputManager outputManager = new OutputManager();
        outputManager.invalidBoardInput();
    }

    public Boolean notPassedTurn() {

        while(true) {
            try {
                return askIfWantToPassTurn();
            } catch (WrongPassMessageException e) {
                printErrorMessage(e);
            }
        }
    }

    private Boolean askIfWantToPassTurn() throws WrongPassMessageException {
        String inputString = scanner.nextLine();
        ValidPassMessage validPassMessage = new ValidPassMessage(inputString);
        return validPassMessage.passMessage().equals("N");
    }

    private void printErrorMessage(Exception e) {
        OutputManager outputManager = new OutputManager();
        outputManager.printErrorMessage(e);
    }
    
}
