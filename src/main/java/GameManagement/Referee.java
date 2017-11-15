package GameManagement;

import java.util.Scanner;

public class Referee {

    Board board;
    int tilesToWin;

    public Referee(Board board, int tilesToWin) {
        this.board = board;
        this.tilesToWin = tilesToWin;
    }

    public boolean checkIfWonHoritontally(String mark) {
        int counter = 0;
        for (int i = 0; i < board.playBoard.size(); i++) {
        if(mark.equals(board.playBoard.get(i).mark)) counter++;
        else counter =0;
            if(counter==tilesToWin) return true;
        }
        return false;
    }

//    public void askIfWantsToContinue() {
//        board.clearBoard();
//        System.out.println(currentPlayer.getName() + " has won this game, do you wish to continue Y/N ?");
//        Scanner scan = new Scanner(System.in);
//        char choice = scan.nextLine().charAt(0);
//        if(choice=='Y') return;
//        else if(choice=='N') isWin=true;
//
//    }
//
//    boolean checkIfWonDiagonally(){
//
//        return false;
//    }
//






//
//    public boolean checkIfDraw() {
//        int counter=0;
//        for(int i=0; i<height; i++){
//            for (int j=0; j<width; j++){
//                if(!(board.playBoard[i][j].equals('e'))){
//                    counter++;
//
//                }
//            }
//        }
//        if(counter==board.playBoard.length) {
//            System.out.println("It is draw !");
//            isDraw=true;
//        }
//        switchCurrentPlayer();
//        return false;
//    }
//
    public boolean checkIfWonVertically(String mark) {
        int counter = 0;
        for (int i = 0; i < board.playBoard.size(); i+=3) {
            if(mark.equals(board.playBoard.get(i).mark)) counter++;
            else counter =0;

            if(counter==tilesToWin) return true;
        }
        return false;
    }
//
//
//    void increaseScore() {
//        if (currentPlayer.getPlayerSign().equals("x")) crossPlayerPoints++;
//        else noughtPlayerPoints++;
//        checkScore();
//    }
//
//    void checkScore() {
//        if (noughtPlayerPoints == 3){
//            System.out.println("The player O has won the entire match");
//            isWin=true;
//        }
//        else if(crossPlayerPoints==3){
//            System.out.println("The player X has won the entire match");
//            isWin=true;
//        }
//
//    }
//



}
