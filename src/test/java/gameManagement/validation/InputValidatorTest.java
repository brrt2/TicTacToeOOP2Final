package gameManagement.validation;

import gameManagement.Board;
import gameManagement.NumberOfMatches;
import gameManagement.PointsForWin;
import gameManagement.boardTools.Height;
import gameManagement.boardTools.Width;
import gameManagement.tiles.TakenTileSign;
import gameManagement.tiles.Tile;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.testng.Assert.*;

public class InputValidatorTest {

    InputValidator iv = new InputValidator();

    @DataProvider(name = "nameValidatorFalse")
    public Object[][] getData() {
        return new Object[][]{{"fdfs_ffsdf fds"}, {"$"}, {"("}, {"%"}, {"fd@ffds^fdfd"}, {"fdsfs 34"}, {"gfdg- 4"}, {"-32"},
                {"fsdf/fdsf"}, {"aBcD%eFgH"}, {"f-4-x fdfsdf"}};
    }

    @DataProvider(name = "nameValidatorTrue")
    public Object[][] getData2() {
        return new Object[][]{{"bartek"}, {"tomek"}, {"adam"}, {"kamil"}, {"bartek dominika"}, {"ryszard adam"}};
    }

    @DataProvider(name = "moveValidator")
    public Object[][] getData3() {
        return new Object[][]{{-5}, {-234}, {3405678}, {-17}, {200000}, {-500}};
    }


    @Test(dataProvider = "nameValidatorFalse")
    public void testValidatePlayerNameFalse(String s) throws Exception {
        assertFalse(iv.validatePlayerName(s));
    }

    @Test(dataProvider = "nameValidatorTrue")
    public void testValidatePlayerNameTrue(String s) throws Exception {
        assertTrue(iv.validatePlayerName(s));
    }

    @Test
    public void validateHowManyMatches() {
        NumberOfMatches numberOfMatches = new NumberOfMatches(-3);
        NumberOfMatches numberOfMatches1 = new NumberOfMatches(5);
        assertFalse(iv.validateHowManyMatches(numberOfMatches));
        assertTrue(iv.validateHowManyMatches(numberOfMatches1));
    }

    @Test
    public void validateHowManyPointsForWin(){
        PointsForWin pointsForWin = new PointsForWin(4);
        PointsForWin pointsForWin1 = new PointsForWin(9999);
        assertTrue(iv.validateHowManyPointsForWin(pointsForWin));
        assertFalse(iv.validateHowManyPointsForWin(pointsForWin1));
    }

    @Test
    public void validateDataStructureSelection() {
        assertTrue(iv.validateDataStructureSelection("a"));
        assertFalse(iv.validateDataStructureSelection("p"));
    }



    @Test
    public void testValidateAdjacentSignsToWin() throws Exception {
        assertTrue(iv.validateAdjacentSignsToWin( 3, 3,3));
        assertFalse(iv.validateAdjacentSignsToWin( 5, 3,3));
    }

    @Test
    public void testValidateBoardDimensions() throws Exception {
        assertTrue(iv.validateBoardDimensions(16));
        assertFalse(iv.validateBoardDimensions(999999));
    }

    @Test(expectedExceptions=IndexOutOfBoundsException.class,dataProvider = "moveValidator")
    public void testValidateMove(int number) throws Exception {
        Player player = new Player("bartek",TakenTileSign.EMPTY);

        Height h = new Height(3);
        Width w = new Width(3);
        List<Tile> list = new ArrayList<>();

        Board board = new Board.Builder()
                .height(h)
                .column(w)
                .playBoard(list)
                .build();

        iv.validateMove(number,player,board);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCheckIfTileTaken() throws Exception {

        Height h = new Height(3);
        Width w = new Width(3);
        List<Tile> list = new ArrayList<>();

        Board board = new Board.Builder()
                .height(h)
                .column(w)
                .playBoard(list)
                .build();


        board.markTile(5, TakenTileSign.CROSS);
        iv.checkIfTileTaken(5, board);
    }





}