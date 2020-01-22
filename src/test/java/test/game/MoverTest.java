package test.game;

import checkers.MoveValidator;
import exceptions.NonAdjacentException;
import exceptions.OccupiedCellException;
import game.GameStatus;
import game.RegularMove;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import output.BoardAsString;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoverTest {

    private String emptyBoardSizeTen = "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n";

    private String firstMoveBoardSizeTen = "|W|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n";

    private String emptyBoardSizeEight = "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" ;

    private GameStatus gameSizeTenBoard;
    private GameStatus gameSizeEightBoard;
    private BoardAsString boardAsString;

    @Before
    public void startGame(){
        gameSizeTenBoard = new GameStatus(10);
        gameSizeEightBoard = new GameStatus(8);
        boardAsString = new BoardAsString();
    }
    
    
    @Test
    public void checkFirstMove() {
        gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(1,1), 'W'));
        assertThat(boardAsString.parsedBoard(gameSizeTenBoard.getBoard()), is(firstMoveBoardSizeTen));
    }

    @Rule
    public ExpectedException exception =
            ExpectedException.none();

   @Test
    public void testOccupiedCellToStringReturnsPreviousBoard() {

       gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(1,1), 'W'));
       List<Integer> occupiedMove = Arrays.asList(1, 1);
       MoveValidator moveValidator = new MoveValidator(1, 1);

       OccupiedCellException thrown = assertThrows(OccupiedCellException.class,
               () -> moveValidator.validate(occupiedMove, false, gameSizeTenBoard.getBoard()));

       assertTrue(thrown.getMessage().contains("Cell is already occupied!"));


    }

    @Test
    public void testNonAdjacentCellToStringReturnsPreviousBoard() {
        gameSizeTenBoard.updateStatus(new RegularMove(Arrays.asList(1,1), 'W'));
        List<Integer> occupiedMove = Arrays.asList(5, 1);
        MoveValidator moveValidator = new MoveValidator(1, 1);

        NonAdjacentException thrown = assertThrows(NonAdjacentException.class,
                () -> moveValidator.validate(occupiedMove, false, gameSizeTenBoard.getBoard()));

        assertTrue(thrown.getMessage().contains("This move must be adjacent to " + Arrays.asList(1, 1)));
    }
    
     
}
