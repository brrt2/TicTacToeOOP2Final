package GameManagement;

import Players.Player;

import java.util.Scanner;

public class Referee {

    Board board;
    int tilesToWin;

    int crossPlayerPoints=0;
    int noughtPlayerPoints=0;

    public Referee(Board board, int tilesToWin) {
        this.board = board;
        this.tilesToWin = tilesToWin;
    }

    public boolean checkIfWonHoritontally(Player currentPlayer) {
        int counter = 0;
        for (int i = 0; i < board.playBoard.size(); i++) {
        if(currentPlayer.getPlayerSign().equals(board.playBoard.get(i).mark)) counter++;
        else counter =0;
            if(counter==tilesToWin){
                increaseScore(currentPlayer);
                board.moveCounter=0;
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonal(Player currentPlayer, int number) {

        int counter = 0;
        for (int i = number-1; i>=0; i-=board.column+1) {
            System.out.println("Checked first loop  " + board.getPlayBoard().get(i));
            if(currentPlayer.getPlayerSign().equals(board.playBoard.get(i).mark))
                counter++;
        }
        for (int i = number-1; i <board.getPlayBoard().size(); i+=board.column+1) {
            System.out.println("Checked second loop " + board.getPlayBoard().get(i));
            if(currentPlayer.getPlayerSign().equals(board.playBoard.get(i).mark)) counter++;
            if(counter-1==tilesToWin){
                increaseScore(currentPlayer);
                board.moveCounter=0;
                return true;
            }
        }




        return false;
    }





//    boolean checkIfWonDiagonally(){
//
//        return false;
//    }
//


    public boolean checkIfDraw() {
        if(board.moveCounter==board.getPlayBoard().size()){
            board.moveCounter=0;
            return true;
        }
        return false;
    }

    public boolean checkIfWonVertically(Player currentPlayer,int number) {
        int counter = 0;
        for (int i = number-1; i>=0; i-=board.column) {
            if(currentPlayer.getPlayerSign().equals(board.playBoard.get(i).mark)) counter++;
        }
        for (int i = number-1; i <board.getPlayBoard().size(); i+=board.column) {
            if(currentPlayer.getPlayerSign().equals(board.playBoard.get(i).mark)) counter++;
            if(counter-1==tilesToWin){
               increaseScore(currentPlayer);
                board.moveCounter=0;
                return true;
            }
        }
        return false;
    }

    public void increaseScore(Player currentPlayer){
        if(currentPlayer.getPlayerSign().equals("x")){
            crossPlayerPoints++;
        }
        else if(currentPlayer.getPlayerSign().equals("o")){
            noughtPlayerPoints++;
        }
    }

    public void checkIfWonMatch(Player currentPlayer){
        if(currentPlayer.getPlayerSign().equals("x")&&crossPlayerPoints==3) {

            System.out.println("Player"+ currentPlayer+ " has won the entire match ! ");
        }else if(currentPlayer.getPlayerSign().equals("o")&&noughtPlayerPoints==3) {

            System.out.println("Player"+ currentPlayer+ " has won the entire match ! ");
        }
    }

    public int getCrossPlayerPoints() {
        return crossPlayerPoints;
    }

    public int getNoughtPlayerPoints() {
        return noughtPlayerPoints;
    }

    public void resetScore() {
        crossPlayerPoints=0;
        noughtPlayerPoints=0;
    }
}
