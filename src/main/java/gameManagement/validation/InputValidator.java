package GameManagement.Validation;

import GameManagement.Board;


public class InputValidator {

  public  boolean validatePlayerName(String name){
       String expression = "^[a-zA-Z ]*$";
       return name.matches(expression);
    }

    public boolean validateAdjacentSignsToWin(int adjacentSigns,int height,int width){
        if (adjacentSigns<0) return false;
        if(adjacentSigns>height||adjacentSigns>width) return false;
        return true;
    }

    public boolean validateBoardDimensions(int dimension){
      if(dimension<=0||dimension>1000) return false;
      return true;
    }

   public void validateMove(int numbertoMark, String playerSign, Board board) throws IllegalArgumentException,ArrayIndexOutOfBoundsException {

        String str= String.valueOf(numbertoMark);
        int valueOfstr;
        try {
            valueOfstr= Integer.parseInt(str);
        } catch (NumberFormatException e) {
        }

        if(numbertoMark<0||numbertoMark>board.getPlayBoard().size()){
            throw new IndexOutOfBoundsException("The provided number is outside the board ! ");
        }else {
            board.markTile(numbertoMark,playerSign);
        }
        if(numbertoMark<0) throw new ArrayIndexOutOfBoundsException();
    }

   public void checkIfTileTaken(int numbertoMark,String playerSign,Board board) throws IllegalArgumentException {

        if(board.getPlayBoard().get(numbertoMark-1).getMark().equals("x")||board.getPlayBoard().get(numbertoMark-1).getMark().equals("o")){

            throw new IllegalArgumentException("The selected tile is already taken !");
        }
    }
}
