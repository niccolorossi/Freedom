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
    
    public void start() {
        gameUntilLastTurn();
        lastTurn();
    }
    
    private void gameUntilLastTurn() {
        for(int turnNumber = 1; turnNumber <= numberOfMoves() - 1; turnNumber++) {
            turn();
        }
    }

    private Integer numberOfMoves() {
        return this.boardSize*this.boardSize;
    }

    private void turn() {

        printNewTurnMessages();
        while(true) {
            List<Integer> coordinates = askForMove();
            try {
                validateMoveAndUpdate(coordinates);
                printUpdatedBoard();
                break;
            } catch (NonAdjacentException | OccupiedCellException e) {
                printErrorMessage(e);
            }
        }
    }

    private void printNewTurnMessages() {
        Character currentPlayer = this.currentPlayer();
        OutputManager outputManager = new OutputManager();
        outputManager.freedomMessage(gameStatus.isFreedom());
        outputManager.currentPlayerTurnMessage(currentPlayer);
    }

    private Character currentPlayer() {
        return gameStatus.currentPlayer();
    }

    private List<Integer> askForMove() {
        InputString inputString = new InputString();
        return inputString.getMove(boardSize);
    }

    private void validateMoveAndUpdate(List<Integer> coordinates) throws NonAdjacentException, OccupiedCellException {
        moveValidator.validate(coordinates, gameStatus.isFreedom(), gameStatus.getBoard());
        RegularMove regularMove = new RegularMove(coordinates, currentPlayer());
        gameStatus.updateStatus(regularMove);
    }

    private void printUpdatedBoard() {
        OutputManager outputManager = new OutputManager();
        outputManager.printBoard(gameStatus.getBoard());
    }

    private void printErrorMessage(Exception e) {
        OutputManager outputManager = new OutputManager();
        outputManager.printErrorMessage(e);
    }
    
    private void lastTurn() {
        printLastTurnMessage();
        askForPassAndUpdate();
        printUpdatedBoard();
        printWinner();
    }
    
    private void printLastTurnMessage() {
        OutputManager outputManager = new OutputManager();
        outputManager.lastTurnMessage(currentPlayer());
    }

    private void askForPassAndUpdate(){
        InputString inputString = new InputString();

        if(inputString.notPassedTurn()) {
            LastMove lastMove = new LastMove(currentPlayer(), gameStatus.getBoard());
            gameStatus.updateStatus(lastMove);
        }
    }
    
    private void printWinner() {
        OutputManager outputManager = new OutputManager();
        outputManager.winnerMessage(gameStatus.winner());
    }
}
