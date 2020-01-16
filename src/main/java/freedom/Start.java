package freedom;

import com.sun.java.swing.action.AboutAction;
import input.InputReader;

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
            
            InputReader inputReader = new InputReader(inputString);

            List<Integer> coordinate = inputReader.getMove(boardSize);
            
            game.move(coordinate.get(0), coordinate.get(1));

            System.out.println(game.toString());
        }
        
    }
}
