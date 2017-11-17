package UserInteraction;

import GameManagement.Board;
import GameManagement.Game;
import Players.Player;

import java.util.Scanner;

public class Printer {



    public static void main(String[] args) {

        new Printer().runTheMenu();

    }

    public void runTheMenu() {
            System.out.println("Welcome to the OOP Tic Tac Toe");
            Scanner scan = new Scanner(System.in);
            System.out.println("Please provide your name (one word)");
            String name = scan.next();
            System.out.println("Please provide your name (one word)");
            String name2 = scan.next();
            Player first = new Player(name,"o");
            Player second = new Player(name2,"x");
            System.out.println("Please select the board height");
            int height = scan.nextInt();
            System.out.println("Please select the board width");
            int width = scan.nextInt();
            System.out.println("Please provide the number of adjacent signs necessary to win ");
            int adjacentSigns = scan.nextInt();
            Board board = new Board(height,width);
            Game game = new Game(first,second,board,adjacentSigns);
            game.setCurrentPlayer(first);

            do{
                game.play();

            }while(!game.isWin);
        }
    }




