package gameManagement;

import gameManagement.moveManagement.Move;
import gameManagement.moveManagement.MoveFactory;
import gameManagement.moveManagement.MoveHistory;
import gameManagement.validation.InputValidator;
import players.Player;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Predicate;

public class Game {

    private boolean isWin = false;
    private Board board;
    private InputValidator mv;
    private Move move;
    private Player firstPlayer;
    private Player secondPlayer;
    private Player currentPlayer;
    private Referee referee;
    private int height;
    private int width;
    private int tilesToWin;
    private Turn turn;


    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Game(Player firstPlayer, Player secondPlayer, Board board, int adjacentSigns) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.board = board;
        tilesToWin = adjacentSigns;
        referee = new Referee(board, tilesToWin);
        mv = new InputValidator();
        turn = new Turn();
    }

    public void switchCurrentPlayer() {
        if (currentPlayer.equals(firstPlayer))
            currentPlayer = secondPlayer;
        else currentPlayer = firstPlayer;

    }

    public void play() {

        int number = -1;
        Scanner scan = new Scanner(System.in);
        System.out.println(board);
        System.out.println("Now is the turn of : " + currentPlayer.getName() + " whose sign is : " + currentPlayer.getPlayerSign());

        System.out.println("Please provide the  number of the tile you want to mark ");
        try {
            number = scan.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Wrong value type !");
        }
        Move move = MoveFactory.createMove(number, currentPlayer);
        MoveHistory.addToArchive(move);

        try {
            mv.checkIfTileTaken(move.getIndex(), currentPlayer.getPlayerSign(), board);
            mv.validateMove(move.getIndex(), currentPlayer, board);
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Wrong number - it has to be positive, fit within the board and point to an empty tile. You have lost your move.");
            System.out.println();
        }

        if (referee.checkIfWonHorizontally(currentPlayer)) {
            isWin = true;
            System.out.println(currentPlayer + " whose sign is : " + currentPlayer.getPlayerSign() + " has won this round  hor!");
            referee.getScore().getCurrentScore();
            if (referee.checkIfWonMatch(currentPlayer) == false) askIfWantsToContinue();
            else askIfWantsToContinueWonEntireMatch("Do you want to play another match ? ");
        }
        try {
            if (referee.checkIfWonVertically(currentPlayer, number)) {
                isWin = true;
                System.out.println(currentPlayer + " whose sign is : " + currentPlayer.getPlayerSign() + " has won this round ver !");
                referee.getScore().getCurrentScore();
                if (referee.checkIfWonMatch(currentPlayer) == false) askIfWantsToContinue();
                else askIfWantsToContinueWonEntireMatch("Do you want to play another match ? ");
            }

            if (referee.checkDiagonal(currentPlayer, number)) {
                isWin = true;
                System.out.println(currentPlayer + " whose sign is : " + currentPlayer.getPlayerSign() + " has won this round diag1 !");
                referee.getScore().getCurrentScore();
                if (referee.checkIfWonMatch(currentPlayer) == false) askIfWantsToContinue();
                else askIfWantsToContinueWonEntireMatch("Do you want to play another match ? ");
            }
            if (referee.checkDiagonal2(currentPlayer, number)) {
                isWin = true;
                System.out.println(currentPlayer + " whose sign is : " + currentPlayer.getPlayerSign() + " has won this round diag2 !");
                referee.getScore().getCurrentScore();
                if (referee.checkIfWonMatch(currentPlayer) == false) askIfWantsToContinue();
                else askIfWantsToContinueWonEntireMatch("Do you want to play another match ? ");
            }
            if (referee.checkIfDraw()) askIfWantsToContinueWonEntireMatch("It is a draw ! Do you want to continue ? ");
        } catch (IndexOutOfBoundsException e) {
            //System.out.println("");
            // scan.next();
        }
        switchCurrentPlayer();
    }

    public void askIfWantsToContinue() {
        System.out.println("Do you wish to continue Y/N ?");
        Scanner scan = new Scanner(System.in);
        char choice = scan.nextLine().toUpperCase().charAt(0);
        if (choice == 'Y') {
            isWin = false;
            board.clearBoard();
        } else if (choice == 'N') isWin = true;
        else {
            System.out.println("None of the possible values selected, the game will be terminted");
            System.out.println("Thank you for playing");
            System.exit(0);
        }
    }

    public void askIfWantsToContinueDraw() {
        System.out.println("It is a draw, do you wish to continue Y/N ?");
        Scanner scan = new Scanner(System.in);
        char choice = scan.nextLine().toUpperCase().charAt(0);
        if (choice == 'Y') board.clearBoard();
        else if (choice == 'N') isWin = true;
        else {
            System.out.println("None of the possible values selected, the game will be terminted");
            System.out.println("Thank you for playing");
            System.exit(0);
        }
    }

    public void askIfWantsToContinueWonEntireMatch(String string) {
        System.out.println(string);
        Scanner scan = new Scanner(System.in);
        char choice = scan.nextLine().toUpperCase().charAt(0);
        if (choice == 'Y') {
            board.clearBoard();
            referee.getScore().resetScore();
            play();
        } else if (choice == 'N') isWin = true;
        else {
            System.out.println("None of the proposed values has been selected, the game will be terminted");
            System.out.println("Thank you for playing");
            System.exit(0);
        }
    }

    public boolean isWin() {
        return isWin;
    }
}
