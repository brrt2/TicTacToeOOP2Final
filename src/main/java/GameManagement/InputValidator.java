package GameManagement;

import Players.Player;

public class InputValidator {

    Board board;

    public InputValidator(Board board) {
        this.board = board;
    }

   boolean validatePlayerName(String name){

        String pattern = String.valueOf(name);

        return false;

    }


    void validateMove(int numbertoMark, String playerSign)throws IllegalArgumentException {

        if(numbertoMark<0||numbertoMark>board.getPlayBoard().size()){
            throw new IllegalArgumentException("The provided number is outside the board ! ");
        }else {
            board.markTile(numbertoMark,playerSign);
        }
    }


}
