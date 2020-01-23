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

        Integer totalNumberOfMoves = numberOfMoves();
        for(int turnNumber = 1; turnNumber <= totalNumberOfMoves - 1; turnNumber++) {
            turn();
        }
        final_turn();
    }
    
    private void turn() {

        Character currentPlayer = this.currentPlayer();
        OutputManager outputManager = new OutputManager();
        outputManager.freedomMessage(gameStatus.isFreedom());
        outputManager.currentPlayerTurnMessage(currentPlayer);

        while(true) {

            InputString inputString = new InputString();
            List<Integer> coordinates = inputString.getMove(boardSize);

            try {
                moveValidator.validate(coordinates, gameStatus.isFreedom(), gameStatus.getBoard());
                RegularMove regularMove = new RegularMove(coordinates, currentPlayer);
                gameStatus.updateStatus(regularMove);
                outputManager.printBoard(gameStatus.getBoard());
                break;
            } catch (NonAdjacentException | OccupiedCellException e) { 
                outputManager.displayMessage(e.getMessage());
            }
        }
        
    }

    private void final_turn() {
        OutputManager  outputManager = new OutputManager();
        Character lastTurnPlayer = gameStatus.currentPlayer();
        outputManager.lastTurnMessage(lastTurnPlayer);

        InputString inputString = new InputString();

        if(inputString.notPassedTurn()) {
            LastMove lastMove = new LastMove(lastTurnPlayer, gameStatus.getBoard());
            gameStatus.updateStatus(lastMove);
        }
        outputManager.printBoard(gameStatus.getBoard());
        outputManager.winnerMessage(gameStatus.winner());
    }
    
}
