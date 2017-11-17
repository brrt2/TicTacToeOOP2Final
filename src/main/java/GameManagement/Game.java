package GameManagement;

import Players.Player;

import java.util.Scanner;

public class Game {

    public boolean isWin = false;
    public boolean isDraw = false;
    Board board;

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
        System.out.println(referee.getCrossPlayerPoints());
        System.out.println(referee.getNoughtPlayerPoints());
        System.out.println("Please provide the  number of the tile you want to mark ");
        int number = scan.nextInt();
        board.markTile(number,currentPlayer.getPlayerSign());
        if(referee.checkIfWonHoritontally(currentPlayer)) {
            isWin=true;
            System.out.println(currentPlayer+ " has won");
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
        System.out.println(currentPlayer.getName() + " has won this game, do you wish to continue Y/N ?");
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
        System.out.println("It is a draw, do you wish to continue Y/N ?");
        Scanner scan = new Scanner(System.in);
        char choice = scan.nextLine().charAt(0);
        if(choice=='Y'){
            board.clearBoard();
            referee.resetScore();
        }
        else if(choice=='N') isWin=true;
    }


}
