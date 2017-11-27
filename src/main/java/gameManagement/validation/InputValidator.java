package gameManagement.validation;

import gameManagement.Board;
import gameManagement.NumberOfMatches;
import gameManagement.PointsForWin;
import gameManagement.tiles.TakenTileSign;
import players.Player;

public class InputValidator {

    public boolean validatePlayerName(String name) {
        String expression = "^[a-zA-Z ]*$";
        return name.matches(expression);
    }

    public boolean validateHowManyMatches(NumberOfMatches numberOfMatches) {
        return numberOfMatches.getValue()>0&&numberOfMatches.getValue()<100;
    }

    public boolean validateHowManyPointsForWin(PointsForWin pointsForWin) {
        return pointsForWin.getValue()>0&&pointsForWin.getValue()<100;
    }

    public boolean validateIfWantsToSwapPlayers(String input) {
        return input.equals("y")||input.equals("n");
    }

    public boolean validateDataStructureSelection(String input) {
        return input.equals("a")||input.equals("l");
    }

    public boolean validateLanguage(String lang) {
        return lang.equals("e")||lang.equals("p")||lang.equals("s");
    }

    public boolean validateTargetConfig (String target) {
        return target.equals("o")||target.equals("e");
    }

    public boolean validateAdjacentSignsToWin(int adjacentSigns, int height, int width) {
        return adjacentSigns >2 && (adjacentSigns <= height && adjacentSigns <= width);
    }

    public boolean validateWhoGoesFirstSign(String str){
        return str.toLowerCase().equals("x")||str.toLowerCase().equals("o");
    }

    public boolean validateBoardDimensions(int dimension) {
        return dimension>2&&dimension<1000;
    }

    public void validateMove(int numbertoMark, Player player, Board board) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {

        //String str = String.valueOf(numbertoMark);
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
