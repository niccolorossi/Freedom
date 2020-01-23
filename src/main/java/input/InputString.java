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
                printInvalidFormatMessage(e1);
            } catch (OutOfBoundsException e2) {
                printOutOfBoundsMessage(e2);
            }
        }
    }

    private List<Integer> askForMoveAndValidateIt(Integer boardSize) throws OutOfBoundsException{
        String inputString =  scanner.nextLine();
        StringToIntegerList stringToIntegerList = new StringToIntegerList(inputString);
        List<Integer> moveList = stringToIntegerList.integerList();
        ValidInputMove validInputMove = new ValidInputMove(boardSize, moveList);
        return validInputMove.inputMove();
    }

    private void printInvalidFormatMessage(Exception e) {
        OutputManager outputManager = new OutputManager();
        outputManager.invalidInputFormat(e);
    }

    private void printOutOfBoundsMessage(OutOfBoundsException e){
        OutputManager outputManager = new OutputManager();
        outputManager.outOfBounds(e);
    }
    

    public Integer getBoardSize() {
        
        while(true) {
            try {
                return askForBoardSizeAndValidatesIt();
            } catch ( NumberFormatException e) {
                printInvalidInputMessage(e);
            } catch (BoardTooSmallException e) {
                printBoardTooSmallMessage(e);
            }
        }
    }

    private Integer askForBoardSizeAndValidatesIt() throws BoardTooSmallException{
        String inputString = scanner.nextLine();
        Integer inputInteger = Integer.parseInt(inputString);
        ValidBoardSize validBoardSize = new ValidBoardSize(inputInteger);
        return validBoardSize.boardSize();

    }

    private void printInvalidInputMessage( Exception e) {
        OutputManager outputManager = new OutputManager();
        outputManager.invalidBoardInput(e);
    }

    private void printBoardTooSmallMessage(BoardTooSmallException e) {
        OutputManager outputManager = new OutputManager();
        outputManager.boardTooSmall(e);
    }

    public Boolean notPassedTurn() {
        
        while(true) {
            try {
               return askIfWantToPassTurn();
            } catch (WrongPassMessageException e) {
                printWrongPassMessage(e);
            }
        }
    }

    private Boolean askIfWantToPassTurn() throws WrongPassMessageException{
        String inputString = scanner.nextLine();
        ValidPassMessage validPassMessage = new ValidPassMessage(inputString);
        return validPassMessage.passMessage().equals("N");
    }

    private void printWrongPassMessage(WrongPassMessageException e) {
        OutputManager outputManager = new OutputManager();
        outputManager.displayMessage(e.getMessage());
    }
}
