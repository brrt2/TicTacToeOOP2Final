package GameManagement;

import Players.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

  public  boolean validatePlayerName(String name){

      // private static final String REGEX = "\\bcat\\b";
    //   private static final String INPUT = "cat cat cat cattie cat";


     //  Pattern p = Pattern.compile(REGEX);
     //  Matcher m = p.matcher(INPUT);

       String expression = "^[a-zA-Z ]*$";
       return name.matches(expression);

    }

    void validateMove(int numbertoMark, String playerSign,Board board) throws IllegalArgumentException,IllegalAccessException {

       if(board.getPlayBoard().get(numbertoMark-1).getMark().equals("x")||board.getPlayBoard().get(numbertoMark-1).getMark().equals("o")){
           throw new IllegalAccessException("The selected tile is already taken !");
       }else {
           board.markTile(numbertoMark,playerSign);
       }

        if(numbertoMark<0||numbertoMark>board.getPlayBoard().size()){
            throw new IllegalArgumentException("The provided number is outside the board ! ");
        }else {
            board.markTile(numbertoMark,playerSign);
        }
    }




}
