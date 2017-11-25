package gameManagement;

import gameManagement.boardTools.TilesToWin;
import gameManagement.locale.Language;
import gameManagement.moveManagement.Move;
import gameManagement.moveManagement.MoveFactory;
import gameManagement.moveManagement.MoveHistory;
import gameManagement.validation.InputValidator;
import userInteraction.Output;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private GameState gameState;
    private Board board;
    private InputValidator mv;
    private Referee referee;
    private TilesToWin tilesToWin;
    private Turn turn;
    private Output output;
    private Language language;


    public Game(Turn turn, Board board, TilesToWin adjacentSigns,Output output,Language language) {
        gameState=GameState.ACTIVE;
        this.board = board;
        tilesToWin = adjacentSigns;
        referee = new Referee(board, tilesToWin);
        mv = new InputValidator();
        this.turn=turn;
        this.output=output;
        this.language=language;
    }

    public void play() {
        int number = obtainTheTileNumber();
        if (referee.checkIfWonHorizontally(turn.getCurrentPlayer())) printIfWon();
        try {
            if (referee.checkIfWonVertically(turn.getCurrentPlayer(), number))printIfWon();
            if (referee.checkDiagonalRL(turn.getCurrentPlayer(), number)) printIfWon();
            if (referee.checkDiagonalLeftToRight(turn.getCurrentPlayer(), number))printIfWon();
            if (referee.checkIfDraw()){
                gameState=GameState.DRAW;
                askIfWantsToContinueWonMatchOrDraw(language.getAskIfWantsToContinueAfterDraw());
            }
        } catch (IndexOutOfBoundsException e) {
            //System.out.println("");
            // scan.next();
        }
        turn.switchCurrentPlayer();
    }


    public void printMessage(){
        output.displayMessage(language.getNowIsTurnOf()+turn.getCurrentPlayer().getName()+ " " +language.getSignOfPlayer()+turn.getCurrentPlayer().getTakenTileSign()+ " " +language.getAskToProvideTileNumber());

    }

    public int obtainTheTileNumber(){
        int number =-1;
        System.out.println(board);
        System.out.println();
        printMessage();
        Scanner scan = new Scanner(System.in);
        try {

           number = scan.nextInt();

        } catch (InputMismatchException e) {
            output.displayMessage(language.getIncorrectValue());
        }
        Move move = MoveFactory.createMove(number, turn.getCurrentPlayer());
        MoveHistory.addToArchive(move);

        try {
            mv.checkIfTileTaken(move.getIndex(), turn.getCurrentPlayer().getTakenTileSign(), board);
            mv.validateMove(move.getIndex(), turn.getCurrentPlayer(), board);
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            output.displayMessage(language.getLostMoveMessage());
            System.out.println();
        }
        return number;
    }

    public void printIfWon(){
        gameState=GameState.WIN;
        output.displayMessage(turn.getCurrentPlayer().getName()+ language.getSignOfPlayer()+turn.getCurrentPlayer().getTakenTileSign()+language.getHasWonThisRound());
        output.displayMessage(language.getPlayerOhas()+referee.getScore().getNoughtPlayerPoints());
        output.displayMessage(language.getPlayerXhas()+referee.getScore().getCrossPlayerPoints());
        if (referee.checkIfWonMatch(turn.getCurrentPlayer()) == false) askIfWantsToContinue();
        else askIfWantsToContinueWonMatchOrDraw(language.getAskIfwantsToPlayAnotherMatch());
    }

    public void askIfWantsToContinue() {
        output.displayMessage(language.getAskIfWantsToContinue());
        Scanner scan = new Scanner(System.in);
        char choice = scan.nextLine().toUpperCase().charAt(0);
        if (choice == 'Y') {
            gameState=GameState.ACTIVE;
            board.clearBoard();
        } else if (choice == 'N') gameState=GameState.WIN;
        else {
            terminateGame();
        }
    }

    public void askIfWantsToContinueWonMatchOrDraw(String string) {
        output.displayMessage(string);
        Scanner scan = new Scanner(System.in);
        char choice = scan.nextLine().toUpperCase().charAt(0);
        if (choice == 'Y') {
            gameState=GameState.ACTIVE;
            board.clearBoard();
            referee.getScore().resetScore();
            //play();
        } else if (choice == 'N') gameState=GameState.WIN;
        else {
            terminateGame();
        }
    }

    public void terminateGame(){
        output.displayMessage(language.getNoneOfTheValuesSelected());
        output.displayMessage(language.getThankYouForPlaying());
        System.exit(0);
    }

    public Turn getTurn() {
        return turn;
    }

    public GameState getGameState() {
        return gameState;
    }

}
