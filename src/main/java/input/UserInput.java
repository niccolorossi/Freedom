package input;

import exceptions.BoardTooSmallException;
import exceptions.OutOfBoundsException;
import exceptions.WrongPassMessageException;

import java.util.List;
import java.util.Scanner;

public class UserInput {
    
    private Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }
    
    public List<Integer> getMove(Integer boardSize) {
        
        while(true) {
            try {
                String inputString = scanner.nextLine();
                StringToIntegerList stringToIntegerList = new StringToIntegerList(inputString);
                List<Integer> moveList = stringToIntegerList.integerList();
                ValidInputMove validInputMove = new ValidInputMove(boardSize, moveList);
                return validInputMove.inputMove();
            } catch (IndexOutOfBoundsException | NumberFormatException | OutOfBoundsException e) {
                System.out.println(e.getMessage());
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
            } catch (BoardTooSmallException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String getPassMessage() {
        
        while(true) {
            try {
                String inputString = scanner.nextLine();
                ValidPassMessage validPassMessage = new ValidPassMessage(inputString);
                return validPassMessage.passMessage();
            } catch (WrongPassMessageException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
