package gamemanagement;

import gamemanagement.locale.Language;
import gamemanagement.moveManagement.Move;
import gamemanagement.moveManagement.MoveFactory;
import gamemanagement.moveManagement.MoveHistory;
import gamemanagement.validation.InputValidator;
import userInteraction.Output;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private GameState gameState;
    private InputValidator mv = new InputValidator();
    private Referee referee;
    private Turn turn;
    private Output output;
    private Language language;
    private Move move;
    private Scanner scan;


    public Game(Turn turn, Output output, Language language,Referee referee,Scanner scan) {
        gameState=GameState.ACTIVE;
        this.referee=referee;
        this.turn=turn;
        this.output=output;
        this.language=language;
        this.scan=scan;
    }

     void play() {
       int number= obtainTheTileNumber();
        try {
            if (referee.checkIfWonHorizontally(turn.getCurrentPlayer(),number)) printIfWon();
            if (referee.checkIfWonVertically(turn.getCurrentPlayer(), number))printIfWon();
            if (referee.checkDiagonalRL(turn.getCurrentPlayer(), number)) printIfWon();
            if (referee.checkDiagonalLeftToRight(turn.getCurrentPlayer(), number))printIfWon();
            if (referee.checkIfDraw()){
                gameState=GameState.DRAW;
                askIfWantsToContinueWonMatchOrDraw(language.getAskIfWantsToContinueAfterDraw());
            }
        } catch (IndexOutOfBoundsException e) {

        }
        turn.switchCurrentPlayer();
    }


    private void printMessage(){
        output.displayMessage(language.getNowIsTurnOf()+turn.getCurrentPlayer().getName()+ " " +language.getSignOfPlayer()+turn.getCurrentPlayer().getTakenTileSign()+ " " +language.getAskToProvideTileNumber());
    }

    private void addToArchive(){
        MoveHistory.addToArchive(move);
    }

    private int obtainTheTileNumber(){
        int number1=0;
        output.displayBoard(referee.getBoard());
        //System.out.println(referee.getBoard());
        //System.out.println();
        printMessage();
            try {
                String number = String.valueOf(scan.nextLine());
                if(number.equals("swap")){
                    referee.getScore().swapScores();
                    output.displayMessage(language.getValuesSwapped());
                    obtainTheTileNumber();
                }
                else if(number.equals("exit")) System.exit(0);
                else number1 = Integer.parseInt(number);
            } catch (NumberFormatException | InputMismatchException | IndexOutOfBoundsException e) {
                output.displayMessage(language.getPressAnyKeyToContinue());
                scan.nextLine();
            }

        move = MoveFactory.createMove(number1, turn.getCurrentPlayer());
        addToArchive();
        validateInput();
        return move.getIndex();
    }

    private void validateInput(){
        try {
            mv.checkIfTileTaken(move.getIndex(), referee.getBoard());
            mv.validateMove(move.getIndex(), turn.getCurrentPlayer(), referee.getBoard());
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            output.displayMessage(language.getLostMoveMessage());
            System.out.println();
        }
    }

    private void printIfWon(){
        gameState=GameState.WIN;
        output.displayMessage(turn.getCurrentPlayer().getName()+ language.getSignOfPlayer()+turn.getCurrentPlayer().getTakenTileSign()+language.getHasWonThisRound());

        System.out.println();
        output.displayMessage(language.getPlayerOhas()+referee.getScore().getNoughtPlayerPoints());
        output.displayMessage(language.getPlayerXhas()+referee.getScore().getCrossPlayerPoints());


        if (referee.checkIfWonMatch(turn.getCurrentPlayer())){
          output.displayMessage(language.getAskIfwantsToPlayAnotherMatch());
            referee.getScore().resetScore();
        }
        else if(referee.checkIfDrawEndMatch()){
            output.displayMessage(language.getAskIfWantsToContinueAfterDraw());
            referee.getScore().resetScore();
        }
        askIfWantsToContinueWonMatchOrDraw(language.getAskIfWantsToContinue());

//        else{
//            gameState=GameState.ACTIVE;
//            referee.getBoard().clearBoard();
//        }

    }

    private void askIfWantsToContinueWonMatchOrDraw(String string) {
        output.displayMessage(string);
        char choice = scan.nextLine().toUpperCase().charAt(0);
        if (choice == 'Y') {
            gameState=GameState.ACTIVE;
            referee.getBoard().clearBoard();
        } else if (choice == 'N') gameState=GameState.WIN;
        else {
            terminateGame();
        }
    }

    private void terminateGame(){
        output.displayMessage(language.getNoneOfTheValuesSelected());
        output.displayMessage(language.getThankYouForPlaying());
        System.exit(0);
    }

    Turn getTurn() {
        return turn;
    }

    GameState getGameState() {
        return gameState;
    }

}
