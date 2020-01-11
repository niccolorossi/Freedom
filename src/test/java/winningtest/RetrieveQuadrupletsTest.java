package winningtest;

import org.junit.Before;
import org.junit.Test;
import winningnic.DiagonalCandidateChecker;
import winningnic.HorizontalCandidateChecker;
import winningnic.VerticalCandidateChecker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RetrieveQuadrupletsTest {

    private Character[][] fullBoard;

    @Before
    public void initFullBoard(){

        fullBoard = new Character[][]
                        {{'B', 'W', 'B', 'W', 'B', 'B', 'W', 'W', 'B', 'W'},
                        {'B', 'W', 'B', 'B', 'W', 'W', 'B', 'B', 'B', 'W'},
                        {'W', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'B'},
                        {'B', 'B', 'W', 'B', 'B', 'W', 'B', 'W', 'W', 'W'},
                        {'W', 'W', 'B', 'W', 'W', 'W', 'B', 'B', 'W', 'B'},
                        {'B', 'B', 'W', 'B', 'B', 'W', 'W', 'B', 'B', 'W'},
                        {'W', 'W', 'B', 'W', 'W', 'B', 'B', 'W', 'B', 'B'},
                        {'W', 'W', 'B', 'W', 'W', 'B', 'W', 'W', 'W', 'W'},
                        {'B', 'B', 'B', 'B', 'W', 'W', 'B', 'B', 'B', 'B'},
                        {'W', 'B', 'W', 'W', 'B', 'B', 'W', 'W', 'W', 'B'}};
    }
    
    @Test
    public void doINeedToCheckHorizontalQuadrupletElementZeroZero() {
        HorizontalCandidateChecker horizontalCandidateChecker = new HorizontalCandidateChecker(fullBoard, 0, 0);
        assertThat(horizontalCandidateChecker.getIsCandidate(), is(false));
    }

    @Test
    public void doINeedToCheckVerticalQuadrupletElementZeroZero() {
        VerticalCandidateChecker verticalCandidateChecker = new VerticalCandidateChecker(fullBoard, 0, 0);
        assertThat(verticalCandidateChecker.getIsCandidate(), is(true));
    }

    @Test
    public void doINeedToCheckDiagonalQuadrupletElementZeroZero() {
        DiagonalCandidateChecker diagonalCandidateChecker = new DiagonalCandidateChecker(fullBoard, 0, 0);
        assertThat(diagonalCandidateChecker.getIsCandidate(), is(true));
    }
      
    
}
