package GameManagement;

import GameManagement.MoveManagement.Move;
import GameManagement.MoveManagement.MoveFactory;
import GameManagement.MoveManagement.MoveHistory;
import GameManagement.Validation.InputValidator;
import Players.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

   private  boolean isWin = false;
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


    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Game(Player firstPlayer, Player secondPlayer, Board board, int adjacentSigns) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.height = height;
        this.width = width;
        this.board = board;
        tilesToWin = adjacentSigns;
        referee = new Referee(board,tilesToWin);
        mv= new InputValidator();
    }

    public Player switchCurrentPlayer() {

        if (currentPlayer.equals(firstPlayer))
            currentPlayer = secondPlayer;
        else currentPlayer = firstPlayer;

        return currentPlayer;
    }

    public void play() {
        int number=-1;
        Scanner scan = new Scanner(System.in);
        System.out.println(board);
        System.out.println("Now is the turn of : " + currentPlayer.getName() + " whose sign is : " +currentPlayer.getPlayerSign());

        System.out.println("Please provide the  number of the tile you want to mark ");
       try {
           number = scan.nextInt();

       }catch(InputMismatchException e){
           System.out.println("Wrong value type !");
       }
        Move move= MoveFactory.createMove(number,currentPlayer);
        MoveHistory.addToArchive(move);

        try {
            mv.checkIfTileTaken(move.getIndex(),currentPlayer.getPlayerSign(),board);
            mv.validateMove(move.getIndex(),currentPlayer.getPlayerSign(),board);
        }catch(IllegalArgumentException | IndexOutOfBoundsException e){
          System.out.println("Wrong number - it has to be positive, fit within the board and point to an empty tile. You have lost your move.");
            System.out.println();
        }

        if(referee.checkIfWonHorizontally(currentPlayer)) {
            isWin=true;
            System.out.println(currentPlayer+" whose sign is : "+currentPlayer.getPlayerSign()+ " has won this round  hor!");
            referee.getScore().getCurrentScore();
            if(referee.checkIfWonMatch(currentPlayer)==false) askIfWantsToContinue();
            else askIfWantsToContinueWonEntireMatch();
        }
        try {
            if (referee.checkIfWonVertically(currentPlayer, number)) {
                isWin = true;
                System.out.println(currentPlayer + " whose sign is : " + currentPlayer.getPlayerSign() + " has won this round ver !");
                referee.getScore().getCurrentScore();
                if (referee.checkIfWonMatch(currentPlayer) == false) askIfWantsToContinue();
                else askIfWantsToContinueWonEntireMatch();
            }

        if(referee.checkDiagonal(currentPlayer,number)){
            isWin=true;
            System.out.println(currentPlayer+" whose sign is : "+currentPlayer.getPlayerSign()+ " has won this round diag1 !");
            referee.getScore().getCurrentScore();
            if(referee.checkIfWonMatch(currentPlayer)==false) askIfWantsToContinue();
            else askIfWantsToContinueWonEntireMatch();
        }
        if(referee.checkDiagonal2(currentPlayer,number)){
            isWin=true;
            System.out.println(currentPlayer+" whose sign is : "+currentPlayer.getPlayerSign()+ " has won this round diag2 !");
            referee.getScore().getCurrentScore();
            if(referee.checkIfWonMatch(currentPlayer)==false) askIfWantsToContinue();
            else askIfWantsToContinueWonEntireMatch();
        }
        if(referee.checkIfDraw()) askIfWantsToContinueDraw();
        }catch(IndexOutOfBoundsException e){
         // System.out.println("Wrong number - it has to be posivite and fit within the board! You have lost your move !");
           // scan.next();
        }
        switchCurrentPlayer();
    }

    public void askIfWantsToContinue() {
        System.out.println("Do you wish to continue Y/N ?");
        Scanner scan = new Scanner(System.in);
        char choice = scan.nextLine().toUpperCase().charAt(0);
        if(choice=='Y'){
            isWin=false;
            board.clearBoard();
        }
        else if(choice=='N') isWin=true;
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
        if(choice=='Y')  board.clearBoard();
        else if(choice=='N') isWin=true;
        else {
            System.out.println("None of the possible values selected, the game will be terminted");
            System.out.println("Thank you for playing");
            System.exit(0);
        }
    }

    public void askIfWantsToContinueWonEntireMatch() {
        System.out.println("Do you want to play one more match Y/N ?");
        Scanner scan = new Scanner(System.in);
        char choice = scan.nextLine().toUpperCase().charAt(0);
        if(choice=='Y'){
            board.clearBoard();
            referee.getScore().resetScore();
            play();
        }
        else if(choice=='N') isWin=true;
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
