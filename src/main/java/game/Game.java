package game;

import exceptions.NonAdjacentException;
import exceptions.OccupiedCellException;
import input.UserInput;

import java.util.List;
import java.util.Scanner;

public class Game implements Runnable {
    
    private GameStatus gameStatus;
    private Integer boardSize;
    
    public Game(Integer boardSize) {
        this.boardSize = boardSize; 
        this.gameStatus = new GameStatus(boardSize);
    }
    
    private Integer numberOfMoves() {
        return this.boardSize*this.boardSize;
    }
    
    private Character currentPlayer() {
        return gameStatus.currentPlayer();
    }

    @Override
    public void run() {
        System.out.println("Players must enter the coordinate of the move!");
        Integer totalNumberOfMoves = numberOfMoves();
        for(int turnNumber = 1; turnNumber <= totalNumberOfMoves - 1; turnNumber++) {
            turn();
            System.out.println(gameStatus.toString());
        }
        Character lastTurnPlayer = gameStatus.currentPlayer();
        System.out.println("Player " + lastTurnPlayer + ", do you want to pass? Y/N");
        Scanner scanner = new Scanner(System.in);
        String passString = scanner.nextLine();
        UserInput userInput = new UserInput(passString);
        String passMessage = userInput.passMessage();
        if(passMessage.equals("N")) {
            gameStatus.lastMove();
            System.out.println(gameStatus.toString());
        } else {
            System.out.println(gameStatus.toString());
        }
        System.out.println(gameStatus.winner());

        
    }
    
    private void turn() {

        Character currentPlayer = this.currentPlayer();
        System.out.println("Player " + currentPlayer + ", it's your turn!");
        while(true) {
            try {
                Scanner in = new Scanner(System.in);
                String inputString = in.nextLine();
                UserInput userInput = new UserInput(inputString);
                List<Integer> coordinate = userInput.getMove(boardSize);
                gameStatus.updateStatus(coordinate.get(0), coordinate.get(1));
                break;
            } catch(NonAdjacentException | OccupiedCellException e) {
                System.out.println(e.getMessage());
            } catch(NullPointerException ignored) {
            }
        }
    }
    
}
