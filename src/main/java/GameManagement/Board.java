package GameManagement;

import Players.Player;

import java.util.ArrayList;
import java.util.List;

public class Board {

    String [][] playBoard;
    int row;
    int column;


    public Board(int row, int column) {
        this.row = row;
        this.column = column;


        playBoard = new String[row][column];

       for(int i=0; i<row; i++){
          for (int j=0; j<column; j++){
            playBoard[i][j] ="e";
          }
        }

    }

    public void showBoard () {
        for(int i=0; i<row; i++){
            for (int j=0; j<column; j++){
                System.out.print(playBoard[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void markTile(int row, int column, String currentPlayer) throws IllegalArgumentException {

        if(row<=0||row>playBoard.length) throw new IllegalArgumentException("Podano nieprawidlowy wymiar !");
        if(column<=0||column>playBoard.length) throw new IllegalArgumentException("Podano nieprawidlowy wymiar !");

        if(getPlayBoard()[row-1][column-1].equals("e")){
            getPlayBoard()[row-1][column-1]=currentPlayer;
        }else throw new IllegalArgumentException("To pole jest juz zajete ! ");

    }

    public void clearBoard(){
        for(int i=0; i<row; i++){
            for (int j=0; j<column; j++){
                playBoard[i][j] ="e";
            }
        }
    }



    public String[][] getPlayBoard() {
        return playBoard;
    }



}
