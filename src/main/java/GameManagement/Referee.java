package GameManagement;

import Players.Player;

import java.util.Scanner;

public class Referee {

    Board board;
    int tilesToWin;

    int crossPlayerPoints;
    int noughtPlayerPoints;




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
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonal() {

        int lastMove;




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

    public boolean checkIfWonVertically(Player currentPlayer) {
        int counter = 0;
        for (int i = 0; i < board.column; i+=board.row) {
            if(currentPlayer.getPlayerSign().equals(board.playBoard.get(i).mark)) counter++;
            else counter =0;

            if(counter==tilesToWin){
                increaseScore(currentPlayer);
                return true;
            }
        }
        return false;
    }

    public void increaseScore(Player currentPlayer){
        if(currentPlayer.getPlayerSign().equals("x")) crossPlayerPoints++;
        else noughtPlayerPoints++;
    }

    public void checkIfWonMatch(Player currentPlayer){
        if(currentPlayer.getPlayerSign()=="x"&&crossPlayerPoints==3) {
            System.out.println("Player"+ currentPlayer+ " has won the entire match ! ");
            System.exit(0);
        }else if(currentPlayer.getPlayerSign()=="o"&&noughtPlayerPoints==3) {
            System.out.println("Player"+ currentPlayer+ " has won the entire match ! ");
            System.exit(0);
        }
    }




}
