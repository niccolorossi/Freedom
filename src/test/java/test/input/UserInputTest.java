package test.input;

import exceptions.BoardTooSmallException;
import input.UserInput;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserInputTest {

    private final List<Integer> firstCell = Arrays.asList(1,1);
    private final Integer boardTenSize = 10;
    private final Integer boardEightSize = 8;
    
    @Test
     public void playFirstCell() {

        String stringMove = "1 1";
        UserInput userInput = new UserInput(stringMove);
        List<Integer> firstMove = userInput.getMove(boardTenSize);
        assertThat(firstMove, is(firstCell));
    }

    @Test
    public void whenNotIntegerInputAnExceptionIsCaught() {

        String stringMove = "e 1";
        UserInput userInput = new UserInput(stringMove);
        userInput.getMove(boardTenSize);
    }
    
    @Test
    public void whenOutOfBoundsAnExceptionIsCaught() {
        
        String stringMove = "11 1";
        UserInput userInput = new UserInput(stringMove);
        userInput.getMove(boardTenSize);
    }
    
    @Test
    public void getMoveWorksWithBoardWithSizeDifferentThanTen() {

        String stringMove = "9 1";
        UserInput userInput = new UserInput(stringMove);
        userInput.getMove(boardEightSize);
    }

    @Test
    public void whenSingleInputAnExceptionIsCaught() {

        String stringMove = "1 ";
        UserInput userInput = new UserInput(stringMove);
        userInput.getMove(boardEightSize);
    }
    
    @Test
    public void testUserInputForGettingBoardSize() throws BoardTooSmallException {
        
        String stringSize = "10";
        UserInput userInput = new UserInput(stringSize);
        assertThat(userInput.getBoardSize(), is(10));
    }
    
    @Test
    public void testWhenBoardSizeIsLessThanFourException() {
        
        String stringSize = "3";
        UserInput userInput = new UserInput(stringSize);
        BoardTooSmallException thrown = assertThrows(BoardTooSmallException.class,
                            () -> userInput.getBoardSize());
                            
         assertTrue(thrown.getMessage().contains("Board size must be greater than or equal to 6!"));
        }
        
    @Test
    public void whenUserInputsEightBoardSizeIsEight() {
        
        String stringBoardSize = "8";
        
    }
        
}
    

