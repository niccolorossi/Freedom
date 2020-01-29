package test.game;

import game.checkers.MoveValidator;
import exceptions.NonAdjacentException;
import exceptions.OccupiedCellException;
import game.GameStatus;
import game.RegularMove;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoverTest {

    private GameStatus gameStatus;

    @Before
    public void startGame(){
        gameStatus = new GameStatus(10);
    }

    @Rule
    public ExpectedException exception =
            ExpectedException.none();

   @Test
    public void testOccupiedCellToStringReturnsPreviousBoard() {

       gameStatus.updateStatus(new RegularMove(Arrays.asList(1,1), 'W'));
       MoveValidator moveValidator = new MoveValidator(1, 1);

       List<Integer> occupiedMove = Arrays.asList(1, 1);

       OccupiedCellException thrown = assertThrows(OccupiedCellException.class,
               () -> moveValidator.validate(occupiedMove, false, gameStatus.getBoard()));

       assertTrue(thrown.getMessage().contains("Cell is already occupied!"));
    }

    @Test
    public void testNonAdjacentCellToStringReturnsPreviousBoard() {
        gameStatus.updateStatus(new RegularMove(Arrays.asList(1,1), 'W'));
        MoveValidator moveValidator = new MoveValidator(1, 1);
        
        List<Integer> nonAdjacentMove = Arrays.asList(5, 1);

        NonAdjacentException thrown = assertThrows(NonAdjacentException.class,
                () -> moveValidator.validate(nonAdjacentMove, false, gameStatus.getBoard()));

        assertTrue(thrown.getMessage().contains("This move must be adjacent to " + Arrays.asList(2, 2)));
    }
    
     
}
