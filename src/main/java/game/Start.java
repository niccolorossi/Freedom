package game;

import input.UserInput;

import java.util.List;
import java.util.Scanner;

public class Start implements Runnable {
    
    private Game game;
    private Integer boardSize;
    
    public Start(Integer boardSize){
        
        this.boardSize = boardSize; 
        game = new Game(boardSize);
        
    }

    @Override
    public void run(){
        System.out.println("Players must enter the coordinate of the move");
        System.out.println("White player start");

        for(int moveNumber = 1; moveNumber < 99; moveNumber++ ){
            
            Scanner in = new Scanner(System.in);
            String inputString = in.nextLine();
            
            UserInput userInput = new UserInput(inputString);

            List<Integer> coordinate = userInput.getMove(boardSize);
            
            game.move(coordinate.get(0), coordinate.get(1));

            System.out.println(game.toString());
        }
        
    }
}
