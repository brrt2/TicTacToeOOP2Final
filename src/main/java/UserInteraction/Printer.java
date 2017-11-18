package UserInteraction;

import GameManagement.Board;
import GameManagement.Game;
import GameManagement.Validation.InputValidator;
import Players.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Printer {

    public static void main(String[] args) {

        new Printer().runTheMenu();

    }

    public void runTheMenu() {
        InputValidator inputValidator = new InputValidator();
        System.out.println("Welcome to the OOP Tic Tac Toe");
        Scanner scan = new Scanner(System.in);
        String name=null;
        String name2=null;
        String value = null;
        int height=0;
        int width=0;
        int adjacentSigns=0;


        while (value == null) {
            System.out.println("Please provide the name of the first player");
            name = scan.nextLine();
            if (inputValidator.validatePlayerName(name) == false) {
                System.out.println("Wrong name !");
            } else {
                value = name;
            }
        }
        value=null;
        while (value == null) {
            System.out.println("Please provide the name of the second player");
            name2 = scan.nextLine();
            if (inputValidator.validatePlayerName(name2) == false) {
                System.out.println("Wrong name!");
            } else {
                value = name;
               // scan.next();
            }
        }
        value=null;

        while (value == null) {
            System.out.println("Please provide the board height");
            try {
                height = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect value");
                scan.next();
            }

            if (inputValidator.validateBoardDimensions(height) == false) {
                System.out.println("Please provide a number higher than 0 and lower than 1000!");
            } else {
                value = name;
            }
        }
        value =null;
        while (value == null) {
            System.out.println("Please provide the board width");
            try {
                width = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect value");
                scan.next();
            }

            if (inputValidator.validateBoardDimensions(width) == false) {
                System.out.println("Please provide a positive number lower than 1000!");
            } else {
                value = name;
            }
        }
        value =null;
        while (value == null) {
            System.out.println("Please provide the number of adjacent signs necessary to win ");
            try {
                adjacentSigns = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect value");
                scan.next();
                adjacentSigns=scan.nextInt();
            }
            if (inputValidator.validateAdjacentSignsToWin(adjacentSigns,height,width) == false) {
                System.out.println("Please provide a positive number lower or equal to board height and width !");
            } else {
                value = name;
            }
        }

               Player first = new Player(name,"o");
               Player second = new Player(name2,"x");
            Board board = new Board(height,width);
         Game game = new Game(first,second,board,adjacentSigns);
            game.setCurrentPlayer(first);

           do{
               game.play();

           }while(!game.isWin());
        }
    }