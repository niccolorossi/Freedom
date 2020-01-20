package input;

import exceptions.BoardTooSmallException;
import exceptions.OutOfBoundsException;
import exceptions.WrongPassMessageException;

import java.util.List;

public class InputString {

    private String inputString;

    public InputString(String inputString) {
        this.inputString = inputString;
    }
    
    public List<Integer> getMove(Integer boardSize) {
        
        while(true) {
                try {
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

                ValidPassMessage validPassMessage = new ValidPassMessage(inputString);
                return validPassMessage.passMessage();
            } catch (WrongPassMessageException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
