package userInteraction;

import gameManagement.Board;
import gameManagement.Game;
import gameManagement.tiles.TileState;
import gameManagement.validation.InputValidator;
import players.Player;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Predicate;

public class Printer {

    private InputValidator inputValidator = new InputValidator();
    private String name = null;
    private String name2 = null;
    private Scanner scan = new Scanner(System.in);
    private int height = 0;
    private int width = 0;
    private int adjacentSigns = 0;


    public static void main(String[] args) {

        new Printer().runTheMenu();
    }

    public void runTheMenu() {

        Predicate<Integer> validBoardDimensions = i -> i > 0 && i < 1000;
        boolean keepTurning = false;
        System.out.println("Welcome to the OOP Tic Tac Toe");
        Predicate<Integer> pr1 = i -> i > 0 && i < 1000;
        obtainUsername("Please provide the name of the first player", keepTurning, name);
        keepTurning = false;
        obtainUsername("Please provide the name of the second player", keepTurning, name2);
        keepTurning = false;
        obtainBoardHeight(pr1,"Please provide the board height",keepTurning);
        keepTurning = false;
        obtainBoardWidth(pr1,"Please provide the board width",keepTurning);
        keepTurning = false;
        int h = height;
        int w = width;
        Predicate<Integer> pr = i -> i > 0 && (i < h && i < w);
        obtainNumberOfAdjacentSigns(pr,keepTurning);
        Player first = new Player(name, "o", TileState.NOUGHT);
        Player second = new Player(name2, "x", TileState.CROSS);
        Board board = new Board(height, width);
        Game game = new Game(first, second, board, adjacentSigns);
        game.setCurrentPlayer(first);

        do {
            game.play();

        } while (!game.isWin());
    }

    public void obtainUsername(String message, boolean keepTurning, String name) {
        while (keepTurning == false) {
            System.out.println(message);
            name = scan.nextLine();
            if (inputValidator.validatePlayerName(name) == false) {
                System.out.println("Wrong name !");
            } else {
                keepTurning = true;
            }
        }
    }

    public void obtainNumberOfAdjacentSigns(Predicate<Integer> pr, boolean keepTurning) {

        while (keepTurning == false) {
            System.out.println("Please provide the number of adjacent signs necessary to win ");
            try {
                adjacentSigns = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect value");
                scan.next();
            }
            if (inputValidator.validateAdjacentSignsToWin(pr, adjacentSigns, height, width) == false) {
                System.out.println("Please provide a positive number lower or equal to board height and width !");
            } else {
                keepTurning = true;
            }
        }
    }

    public void obtainBoardHeight(Predicate<Integer> pr1, String msg,boolean keepTurning) {

        while (keepTurning == false) {
            System.out.println(msg);
            try {
                height = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect value !");
                scan.next();
            }
            if (inputValidator.validateBoardDimensions(pr1, height) == false) {
                System.out.println("Please provide a number higher than 0 and lower than 1000!");
            } else {
                keepTurning = true;
            }
        }
    }

    public void obtainBoardWidth(Predicate<Integer> pr1, String msg,boolean keepTurning) {

        while (keepTurning == false) {
            System.out.println(msg);
            try {
                width = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect value !");
                scan.next();
            }
            if (inputValidator.validateBoardDimensions(pr1, width) == false) {
                System.out.println("Please provide a number higher than 0 and lower than 1000!");
            } else {
                keepTurning = true;
            }
        }
    }
}