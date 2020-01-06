import it.freedom.Game;
import it.freedom.exceptions.OutOfBoundsException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    private String emptyBoard10 = "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|_|_|";

    private String emptyBoard8 = "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|\n" +
            "|_|_|_|_|_|_|_|_|" ;

    private Game game10;
    private Game game8;

    @Before
    public void startGame(){
        game10 = new Game(10);
        game8 = new Game(8);
    }

    @Test
    public void isEmptyBoard10(){

        assertThat(game10.toString(), is(emptyBoard10));

    }

    @Test
    public void isEmptyBoard8(){

        assertThat(game8.toString(), is(emptyBoard8));
    }

    @Test
    public void whenXOutsideBoardThenOutOfBoundsException() throws OutOfBoundsException {


            OutOfBoundsException thrown = assertThrows(OutOfBoundsException.class, () -> {
                game10.playerMove(11,1);
            });
            assertTrue(thrown.getMessage().contains("11 is out of bound!"));

    }

    @Test
    public void whenYOutsideBoardThenOutOfBoundsException() throws OutOfBoundsException {


        OutOfBoundsException thrown = assertThrows(OutOfBoundsException.class, () -> {
            game10.playerMove(1,11);
        });
        assertTrue(thrown.getMessage().contains("11 is out of bound!"));

    }
    


}