package GameManagement;

import Players.Player;

import java.util.Scanner;

public class Game {

    public boolean isWin = false;
    public boolean isDraw = false;
    Board board;
    InputValidator mv;

    Player firstPlayer;
    Player secondPlayer;
    Player currentPlayer;
    Referee referee;

    int height;
    int width;
    int tilesToWin;


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
        mv= new InputValidator(board);
    }

    public Player switchCurrentPlayer() {

        if (currentPlayer.equals(firstPlayer))
            currentPlayer = secondPlayer;
        else currentPlayer = firstPlayer;

        return currentPlayer;
    }


    public void play() {

        Scanner scan = new Scanner(System.in);
        System.out.println(board);
        System.out.println("Now is the turn of : " + currentPlayer.getName() + " whose sign is : " +currentPlayer.getPlayerSign());

        System.out.println("Please provide the  number of the tile you want to mark ");
        int number = scan.nextInt();
        //board.markTile(number,currentPlayer.getPlayerSign());
        try {
            mv.validateMove(number,currentPlayer.getPlayerSign());
        }catch(IllegalArgumentException e){
            System.out.println("The provided tile number is outside the board ! You loose your move ! ");
            System.out.println();
        }

        if(referee.checkIfWonHoritontally(currentPlayer)) {
            isWin=true;
            System.out.println(currentPlayer+" whose sign is : "+currentPlayer.getPlayerSign()+ " has won this round !");
            System.out.println("Player X has : " +referee.getCrossPlayerPoints());
            System.out.println("Player O has : " + referee.getNoughtPlayerPoints());
            referee.checkIfWonMatch(currentPlayer);
            askIfWantsToContinue();
        }
        if(referee.checkIfWonVertically(currentPlayer)){
            isWin=true;
            System.out.println(currentPlayer+ " has won");
            referee.checkIfWonMatch(currentPlayer);
            askIfWantsToContinue();
        }
//        if(referee.checkDiagonalWin(currentPlayer.getPlayerSign())){
//            isWin=true;
//            System.out.println(currentPlayer+ "has won diag0");
//        }
//        if(referee.checkIfWonDiagonally2(currentPlayer.getPlayerSign())){
//            isWin=true;
//            System.out.println(currentPlayer+ "has won");
//        }

        if(referee.checkIfDraw()) askIfWantsToContinueDraw();


        switchCurrentPlayer();
    }

    public void askIfWantsToContinue() {
        System.out.println("Do you wish to continue Y/N ?");
        Scanner scan = new Scanner(System.in);
        char choice = scan.nextLine().charAt(0);
        if(choice=='Y'){
            isWin=false;
            board.clearBoard();
        }
        else if(choice=='N') isWin=true;
    }

    public void askIfWantsToContinueDraw() {
        System.out.println("It is a draw, do you wish to continue Y/N ?");
        Scanner scan = new Scanner(System.in);
        char choice = scan.nextLine().charAt(0);
        if(choice=='Y')  board.clearBoard();
        else if(choice=='N') isWin=true;
    }

    public void askIfWantsToContinueWonEntireMatch() {
        System.out.println("Do you want to play again Y/N ?");
        Scanner scan = new Scanner(System.in);
        char choice = scan.nextLine().charAt(0);
        if(choice=='Y'){
            board.clearBoard();
            referee.resetScore();
        }
        else if(choice=='N') isWin=true;
    }

}
