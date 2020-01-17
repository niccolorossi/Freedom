package game;

import exceptions.NonAdjacentException;
import exceptions.OccupiedCellException;
import input.UserInput;

import java.util.List;
import java.util.Scanner;

public class Game implements Runnable {
    
    private GameState game;
    private Integer boardSize;
    
    public Game(Integer boardSize) {
        this.boardSize = boardSize; 
        this.game = new GameState(boardSize);
    }

    @Override
    public void run() {
        System.out.println("Players must enter the coordinate of the move!");

        for(int moveNumber = 1; moveNumber < 99; moveNumber++) {
            System.out.println("Player " + game.currentPlayer() + ", it's your turn!");
            
            turn();
            
            System.out.println(game.toString());
        }
        
    }
    
    private void turn(){

        Scanner in = new Scanner(System.in);
        UserInput userInput;
        List<Integer> coordinate;
        while(true) {
            try {
                String inputString = in.nextLine();
                userInput = new UserInput(inputString);
                coordinate = userInput.getMove(boardSize);
                game.updateState(coordinate.get(0), coordinate.get(1));
                break;
            } catch(NonAdjacentException | OccupiedCellException e) {
                System.out.println(e.getMessage());
            } catch(NullPointerException ignored) {

            }
        }
        
    }
    
}
