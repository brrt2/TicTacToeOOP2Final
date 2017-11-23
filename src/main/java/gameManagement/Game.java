package gameManagement;

import gameManagement.moveManagement.Move;
import gameManagement.moveManagement.MoveFactory;
import gameManagement.moveManagement.MoveHistory;
import gameManagement.validation.InputValidator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private GameState gameState;
    private Board board;
    private InputValidator mv;
    private Referee referee;
    private int tilesToWin;
    private Turn turn;

    public Game(Turn turn, Board board, int adjacentSigns) {
        gameState=GameState.ACTIVE;
        this.board = board;
        tilesToWin = adjacentSigns;
        referee = new Referee(board, tilesToWin);
        mv = new InputValidator();
        this.turn=turn;
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
                askIfWantsToContinueWonMatchOrDraw("It is a draw ! Do you want to continue ? ");
            }
        } catch (IndexOutOfBoundsException e) {
            //System.out.println("");
            // scan.next();
        }
        turn.switchCurrentPlayer();
    }

    public int obtainTheTileNumber(){
        int number =-1;
        Scanner scan = new Scanner(System.in);
        System.out.println(board);
        System.out.println("Now is the turn of : " + turn.getCurrentPlayer().getName() + " whose sign is : " + turn.getCurrentPlayer().getTakenTileSign());
        System.out.println("Please provide the  number of the tile you want to mark ");
        try {
           number = scan.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Wrong value type !");
        }
        Move move = MoveFactory.createMove(number, turn.getCurrentPlayer());
        MoveHistory.addToArchive(move);

        try {
            mv.checkIfTileTaken(move.getIndex(), turn.getCurrentPlayer().getTakenTileSign(), board);
            mv.validateMove(move.getIndex(), turn.getCurrentPlayer(), board);
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Wrong number - it has to be positive, fit within the board and point to an empty tile. You have lost your move.");
            System.out.println();
        }
        return number;
    }


    public void printIfWon(){
        gameState=GameState.WIN;
        System.out.println(turn.getCurrentPlayer() + " whose sign is : " + turn.getCurrentPlayer().getTakenTileSign() + " has won this round!");
        referee.getScore().getCurrentScore();
        if (referee.checkIfWonMatch(turn.getCurrentPlayer()) == false) askIfWantsToContinue();
        else askIfWantsToContinueWonMatchOrDraw("Do you want to play another match Y/N ? ");
    }


    public void askIfWantsToContinue() {
        System.out.println("Do you wish to continue Y/N ?");
        Scanner scan = new Scanner(System.in);
        char choice = scan.nextLine().toUpperCase().charAt(0);
        if (choice == 'Y') {
            gameState=GameState.ACTIVE;
            board.clearBoard();
        } else if (choice == 'N') gameState=GameState.WIN;
        else {
            System.out.println("None of the proposed values selected, the game will be terminated");
            System.out.println("Thank you for playing");
            System.exit(0);
        }
    }

    public void askIfWantsToContinueWonMatchOrDraw(String string) {
        System.out.println(string);
        Scanner scan = new Scanner(System.in);
        char choice = scan.nextLine().toUpperCase().charAt(0);
        if (choice == 'Y') {
            gameState=GameState.ACTIVE;
            board.clearBoard();
            referee.getScore().resetScore();
            //play();
        } else if (choice == 'N') gameState=GameState.WIN;
        else {
            System.out.println("None of the proposed values has been selected, the game will be terminated");
            System.out.println("Thank you for playing");
            System.exit(0);
        }
    }

    public Turn getTurn() {
        return turn;
    }

    public GameState getGameState() {
        return gameState;
    }

}
