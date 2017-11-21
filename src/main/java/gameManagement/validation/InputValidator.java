package gameManagement.validation;

import gameManagement.Board;
import gameManagement.tiles.TakenTileSign;
import players.Player;

import java.util.function.Predicate;

public class InputValidator {

    public boolean validatePlayerName(String name) {
        String expression = "^[a-zA-Z ]*$";
        return name.matches(expression);
    }

    public boolean validateAdjacentSignsToWin(int adjacentSigns, int height, int width) {
        return adjacentSigns>0&&(adjacentSigns<=height&&adjacentSigns<=width);
    }

    public boolean validateWhoGoesFirstSign(String str){
        return str.toLowerCase().equals("x")||str.toLowerCase().equals("o");
    }

    public boolean validateBoardDimensions(int dimension) {
        return dimension>0&&dimension<1000;
    }

    public void validateMove(int numbertoMark, Player player, Board board) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {

        String str = String.valueOf(numbertoMark);
//        int valueOfstr;
//            valueOfstr = Integer.parseInt(str);
        if (numbertoMark < 0 || numbertoMark > board.getPlayBoard().size()) {
            throw new IndexOutOfBoundsException("The provided number is outside the board ! ");
        } else {
            board.markTile(numbertoMark, player.getTakenTileSign());
        }
        if (numbertoMark < 0) throw new ArrayIndexOutOfBoundsException();
    }

    public void checkIfTileTaken(int numbertoMark, TakenTileSign takenTileSign, Board board) throws IllegalArgumentException {
        if (board.getPlayBoard().get(numbertoMark - 1).getTakenTileSign().equals(TakenTileSign.CROSS) || board.getPlayBoard().get(numbertoMark - 1).getTakenTileSign().equals(TakenTileSign.NOUGHT)) {
            throw new IllegalArgumentException("The selected tile is already taken !");
        }
    }
}
