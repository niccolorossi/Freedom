package game;

import exceptions.NonAdjacentException;
import exceptions.OccupiedCellException;
import input.UserInput;

import java.util.List;
import java.util.Scanner;

public class Play implements Runnable {
    
    private Game game;
    private Integer boardSize;
    private Character newStone;
    
    public Play(Integer boardSize) {
        this.boardSize = boardSize; 
        this.game = new Game(boardSize);
        this.newStone = 'W';
    }

    @Override
    public void run() {
        System.out.println("Players must enter the coordinate of the move!");

        for(int moveNumber = 1; moveNumber < 99; moveNumber++) {
            System.out.println("Player " + newStone + ", it's your turn!");
            
            Scanner in = new Scanner(System.in);
            UserInput userInput;
            List<Integer> coordinate;
            while(true) {
                try {
                    String inputString = in.nextLine();
                    userInput = new UserInput(inputString);
                    coordinate = userInput.getMove(boardSize);
                    game.move(newStone, coordinate.get(0), coordinate.get(1));
                    break;
                } catch(NonAdjacentException | OccupiedCellException e) {
                    System.out.println(e.getMessage());
                } catch(NullPointerException ignored) {
                    
                }
            }

            this.changeNewStone();
            game.isNextMoveFreedom(coordinate.get(0), coordinate.get(1));
            game.setPreviousCoordinates(coordinate.get(0), coordinate.get(1));
            game.setFirstMove();
            
            System.out.println(game.toString());
        }
        
    }
    
    private void changeNewStone() {
        if(newStone.equals('W')) {
            newStone = 'B';
        } else newStone = 'W';
    }
}
