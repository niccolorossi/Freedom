package game;

import checkers.MoveValidator;
import exceptions.NonAdjacentException;
import exceptions.OccupiedCellException;
import input.InputString;
import output.OutputManager;

import java.util.List;

public class Game {
    
    private GameStatus gameStatus;
    private Integer boardSize;
    private MoveValidator moveValidator;
    
    public Game(Integer boardSize) {
        this.boardSize = boardSize; 
        this.gameStatus = new GameStatus(boardSize);
        this.moveValidator = new MoveValidator();
    }
    
    private Integer numberOfMoves() {
        return this.boardSize*this.boardSize;
    }
    
    private Character currentPlayer() {
        return gameStatus.currentPlayer();
    }
    
    public void start() {
        OutputManager outputManager = new OutputManager();
        Integer totalNumberOfMoves = numberOfMoves();

        for(int turnNumber = 1; turnNumber <= totalNumberOfMoves - 1; turnNumber++) {
            turn();
            outputManager.printBoard(gameStatus.getBoard());
        }
        Character lastTurnPlayer = gameStatus.currentPlayer();
        outputManager.lastTurnMessage(lastTurnPlayer);
        InputString inputString = new InputString();

        if(inputString.getPassMessage()) {
            LastMove lastMove = new LastMove(lastTurnPlayer, gameStatus.getBoard());
            gameStatus.updateStatus(lastMove);
        }
        outputManager.printBoard(gameStatus.getBoard());
        String winnerString = gameStatus.winner();
        outputManager.displayMessage(winnerString);
        
    }
    
    private void turn() {
        Character currentPlayer = this.currentPlayer();
        OutputManager outputManager = new OutputManager();
        outputManager.currentPlayerTurnMessage(currentPlayer);
        while(true) {
            InputString inputString = new InputString();
            List<Integer> coordinates = inputString.getMove(boardSize);
            try {
                moveValidator.validate(coordinates, gameStatus.isFreedom(), gameStatus.getBoard());
                RegularMove regularMove = new RegularMove(coordinates, currentPlayer);
                gameStatus.updateStatus(regularMove);
                break;
            } catch (NonAdjacentException | OccupiedCellException e) { 
                String errorMessage = e.getMessage();
                outputManager.displayMessage(errorMessage);
            }
        }
        
    }
    
}
