package GameManagement;

import java.util.ArrayList;
import java.util.List;

public class Board {


    int row;
    int column;
    List<Tile> playBoard;
    int moveCounter=0;


    public Board(int row, int column) {
        playBoard = new ArrayList<Tile>(row*column);
        this.row=row;
        this.column=column;
        populateTheBoard();
    }

    public void populateTheBoard(){
        for(int i = 0; i< row*column; i++){
            playBoard.add(new Tile(i+1));
        }
    }


//    public void showBoard () {
//        for(int i=0; i<row; i++){
//            for (int j=0; j<column; j++){
//                System.out.print(playBoard[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
//
//    public void markTile(int row, int column, String currentPlayer) throws IllegalArgumentException {
//
//        if(row<=0||row>playBoard.length) throw new IllegalArgumentException("Podano nieprawidlowy wymiar !");
//        if(column<=0||column>playBoard.length) throw new IllegalArgumentException("Podano nieprawidlowy wymiar !");
//
//        if(getPlayBoard()[row-1][column-1].equals("e")){
//            getPlayBoard()[row-1][column-1]=currentPlayer;
//        }else throw new IllegalArgumentException("To pole jest juz zajete ! ");
//
//    }

    void markTile(int number, String toMark) {

        playBoard.get(number-1).mark=toMark;
        moveCounter++;
    }
//
    public void clearBoard(){
        playBoard=new ArrayList<Tile>(row*column);
        populateTheBoard();
    }

    public List<Tile> getPlayBoard() {
        return playBoard;
    }


    //
//
//
//    public String[][] getPlayBoard() {
//        return playBoard;
//    }

    @Override
    public String toString() {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (Tile tile : playBoard) {
            sb.append(tile);
            count++;
            if(count == column) {
                sb.append(" \n");
                count = 0;
            }
        }
        return sb.toString();
    }
}
