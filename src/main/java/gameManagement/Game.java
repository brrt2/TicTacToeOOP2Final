package gameManagement;

import gameManagement.boardTools.Height;
import gameManagement.boardTools.TilesToWin;
import gameManagement.boardTools.Width;
import gameManagement.locale.Language;
import gameManagement.moveManagement.Move;
import gameManagement.moveManagement.MoveFactory;
import gameManagement.moveManagement.MoveHistory;
import gameManagement.tiles.Tile;
import gameManagement.validation.InputValidator;
import userInteraction.Output;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Game {

    private GameState gameState;
    private InputValidator mv;
    private Referee referee;
    private Turn turn;
    private Output output;
    private Language language;
    private Move move;


    public Game(Turn turn, Board board, TilesToWin adjacentSigns, Output output, Language language, NumberOfMatches numberOfMatches, PointsForWin pointsForWin) {
       createReferee(board, adjacentSigns, numberOfMatches,pointsForWin);
       setGameStateToActive();
       createValidator();
        this.turn=turn;
        this.output=output;
        this.language=language;
    }

    private void createReferee(Board board1,TilesToWin tilesToWin, NumberOfMatches numberOfMatches, PointsForWin pointsForWin){
        referee = new Referee(board1, tilesToWin,numberOfMatches,pointsForWin);
    }

    private void setGameStateToActive(){
        gameState=GameState.ACTIVE;
    }

    private void createValidator(){
        mv = new InputValidator();
    }

     void play() {
       int number= obtainTheTileNumber();

        try {
            if (referee.checkIfWonHorizontally(turn.getCurrentPlayer())) printIfWon();
            if (referee.checkIfWonVertically(turn.getCurrentPlayer(), number))printIfWon();
            if (referee.checkDiagonalRL(turn.getCurrentPlayer(), number)) printIfWon();
            if (referee.checkDiagonalLeftToRight(turn.getCurrentPlayer(), number))printIfWon();
            if (referee.checkIfDraw()){
                gameState=GameState.DRAW;
                askIfWantsToContinueWonMatchOrDraw(language.getAskIfWantsToContinueAfterDraw());
            }
        } catch (IndexOutOfBoundsException e) {
            output.displayMessage("An issue with win checking in the Game class");
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
        //System.out.println(board);
        System.out.println(referee.getBoard());
        System.out.println();
        printMessage();
        Scanner scan = new Scanner(System.in);
        try {

          int number = scan.nextInt();
           move = MoveFactory.createMove(number, turn.getCurrentPlayer());
        } catch (InputMismatchException e) {
            output.displayMessage(language.getIncorrectValue());
        }

        addToArchive();
        try {
            mv.checkIfTileTaken(move.getIndex(), turn.getCurrentPlayer().getTakenTileSign(), referee.getBoard());
            mv.validateMove(move.getIndex(), turn.getCurrentPlayer(), referee.getBoard());
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            output.displayMessage(language.getLostMoveMessage());
            System.out.println();
        }
        return move.getIndex();
    }

    private void printIfWon(){
        gameState=GameState.WIN;
        output.displayMessage(turn.getCurrentPlayer().getName()+ language.getSignOfPlayer()+turn.getCurrentPlayer().getTakenTileSign()+language.getHasWonThisRound());
        output.displayMessage(language.getPlayerOhas()+referee.getScore().getNoughtPlayerPoints());
        output.displayMessage(language.getPlayerXhas()+referee.getScore().getCrossPlayerPoints());
        if (!referee.checkIfWonMatch(turn.getCurrentPlayer())) askIfWantsToContinue();
        else askIfWantsToContinueWonMatchOrDraw(language.getAskIfwantsToPlayAnotherMatch());
    }

    private void askIfWantsToContinue() {
        output.displayMessage(language.getAskIfWantsToContinue());
        Scanner scan = new Scanner(System.in);
        char choice = scan.nextLine().toUpperCase().charAt(0);
        if (choice == 'Y') {
            gameState=GameState.ACTIVE;
            referee.getBoard().clearBoard();
        } else if (choice == 'N') gameState=GameState.WIN;
        else {
            terminateGame();
        }
    }

    private void askIfWantsToContinueWonMatchOrDraw(String string) {
        output.displayMessage(string);
        Scanner scan = new Scanner(System.in);
        char choice = scan.nextLine().toUpperCase().charAt(0);
        if (choice == 'Y') {
            gameState=GameState.ACTIVE;
            referee.getBoard().clearBoard();
            referee.getScore().resetScore();
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
