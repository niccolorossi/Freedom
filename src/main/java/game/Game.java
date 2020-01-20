package game;

import exceptions.NonAdjacentException;
import exceptions.OccupiedCellException;
import input.InputString;

import java.util.List;

public class Game {
    
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


    public void start() {
        System.out.println("Players must enter the coordinate of the move!");
        Integer totalNumberOfMoves = numberOfMoves();
        for(int turnNumber = 1; turnNumber <= totalNumberOfMoves - 1; turnNumber++) {
            turn();
            System.out.println(gameStatus.toString());
        }
        Character lastTurnPlayer = gameStatus.currentPlayer();
        System.out.println("Player " + lastTurnPlayer + ", do you want to pass? Y/N");
        InputString inputString = new InputString();
        String passMessage = inputString.getPassMessage();
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
        InputString inputString = new InputString();
        List<Integer> coordinate = inputString.getMove(boardSize);
        try {
            gameStatus.updateStatus(coordinate.get(0), coordinate.get(1));
        } catch (NonAdjacentException | OccupiedCellException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
