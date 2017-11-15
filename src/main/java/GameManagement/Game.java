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

    int height;
    int width;
    int tilesToWin;
    int crossPlayerPoints;
    int noughtPlayerPoints;


    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Game(Player firstPlayer, Player secondPlayer, int height, int width, int adjacentSigns) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.height = height;
        this.width = width;
        board = new Board(height, width);
        tilesToWin = adjacentSigns;
    }

    public Player switchCurrentPlayer() {

        if (currentPlayer.equals(firstPlayer))
            currentPlayer = secondPlayer;
        else currentPlayer = firstPlayer;

        return currentPlayer;
    }


    public boolean checkIfWonHoritontally() {
        int counter = 0;
        for (int i = 0; i < board.getPlayBoard().length; i++) {

            for (int j = 0; j < board.getPlayBoard()[i].length; j++) {

                if (board.playBoard[i][j].equals(currentPlayer.getPlayerSign())) {
                    counter++;
                }
            }
            if (counter < tilesToWin) counter = 0;
            else if (counter == tilesToWin) {
                System.out.println(currentPlayer.getName() + " has won, Congratulations  !");
                increaseScore();
                askIfWantsToContinue();
                return true;
            }
        }
        checkIfWonVertically();
        return false;
    }

    public void askIfWantsToContinue() {
        board.clearBoard();
        System.out.println(currentPlayer.getName() + " has won this game, do you wish to continue Y/N ?");
        Scanner scan = new Scanner(System.in);
        char choice = scan.nextLine().charAt(0);
        if(choice=='Y') return;
        else if(choice=='N') isWin=true;

    }

    boolean checkIfWonDiagonally(){

        return false;
    }

    boolean checkIfWonDiagonally2() {
        return false;
    }

    public boolean checkIfDraw() {
        int counter=0;
        for(int i=0; i<height; i++){
            for (int j=0; j<width; j++){
                if(!(board.playBoard[i][j].equals('e'))){
                    counter++;

                }
            }
        }
        if(counter==board.playBoard.length) {
            System.out.println("It is draw !");
            isDraw=true;
        }
        switchCurrentPlayer();
        return false;
    }

    public boolean checkIfWonVertically() {
        int counter = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (board.playBoard[j][i].equals(currentPlayer.getPlayerSign())) {
                    counter++;
                }

            }
            if (counter < tilesToWin) counter = 0;
            else if (counter == tilesToWin) {
                System.out.println(currentPlayer.getName() + " has won v, Congratulations  !");
                increaseScore();
                askIfWantsToContinue();
                return true;
            }
        }
        checkIfDraw();
        return false;
    }


    public void play() {
        Scanner scan = new Scanner(System.in);
        board.showBoard();
        System.out.println("Please provide the row number of the tile you want to mark ");
        int row = scan.nextInt();
        System.out.println("Please provide the column number of the tile you want to mark ");
        int column = scan.nextInt();
        board.markTile(row, column, currentPlayer.getPlayerSign());
        checkIfWonHoritontally();
    }


    void increaseScore() {
        if (currentPlayer.getPlayerSign().equals("x")) crossPlayerPoints++;
        else noughtPlayerPoints++;
        checkScore();
    }

    void checkScore() {
        if (noughtPlayerPoints == 3){
            System.out.println("The player O has won the entire match");
            isWin=true;
        }
        else if(crossPlayerPoints==3){
            System.out.println("The player X has won the entire match");
            isWin=true;
        }

    }

}
