package input;

import exceptions.BoardTooSmall;
import exceptions.OutOfBoundsException;

import java.io.BufferedReader;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    
    private BufferedReader bufferedReader;
    
    public UserInput(String inputLine) {
        BufferedReaderInitializer bufferedReaderInitializer = new BufferedReaderInitializer(inputLine);
        this.bufferedReader = bufferedReaderInitializer.getBufferedReader();
    }

    public UserInput() {
        
    }

    private String asString() {
        InputString inputString = new InputString(bufferedReader);
        return inputString.getStringRead();
    }

    
    public List<Integer> getMove(Integer boardSize) {
        
        while(true) {
            try {
                Scanner scanner = new Scanner(System.in);
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
                Scanner scanner = new Scanner(System.in);
                String inputString = scanner.nextLine();
                Integer inputInteger = Integer.parseInt(inputString);
                ValidBoardSize validBoardSize = new ValidBoardSize(inputInteger);
                return validBoardSize.boardSize();
            } catch (BoardTooSmall | NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String passMessage() {
        return this.asString();
    }
}
