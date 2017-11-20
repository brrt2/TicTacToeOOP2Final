package GameManagement.Validation;

import GameManagement.Board;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ExpectedExceptionsAnnotation;

import static org.testng.Assert.*;

public class InputValidatorTest {

    InputValidator iv= new InputValidator();

    @DataProvider(name="nameValidatorFalse")
    public Object[][] getData() {
        return new Object[][]{{"fdfs_ffsdf fds"},{"$"},{"("},{"%"},{"fd@ffds^fdfd"},{"fdsfs 34"},{"gfdg- 4"},{"-32"},
                {"fsdf/fdsf"},{"aBcD%eFgH"},{"f-4-x fdfsdf"}};
    }

    @DataProvider(name="nameValidatorTrue")
    public Object[][] getData2() {
        return new Object[][]{{"bartek"},{"tomek"},{"adam"},{"kamil"},{"bartek dominika"},{"ryszard adam"}};
    }

    @DataProvider(name="moveValidator")
    public Object[][] getData3() {
        return new Object[][]{{-5},{-234},{3405678},{-17},{200000},{-500}};
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
    public void testValidateAdjacentSignsToWin() throws Exception {
    assertTrue(iv.validateAdjacentSignsToWin(3,3,3));
    assertFalse(iv.validateAdjacentSignsToWin(-2,3,3));

    }

    @Test
    public void testValidateBoardDimensions() throws Exception {
        assertTrue(iv.validateBoardDimensions(16));
        assertFalse(iv.validateBoardDimensions(999999));
    }

    @Test(expectedExceptions=IndexOutOfBoundsException.class,dataProvider = "moveValidator")
    public void testValidateMove(int number) throws Exception {
        Board board = new Board(3,3);
        iv.validateMove(number,"x",board);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCheckIfTileTaken() throws Exception {
        Board board = new Board(3,3);
        board.markTile(5,"x");
        iv.checkIfTileTaken(5,"o",board);
    }

}