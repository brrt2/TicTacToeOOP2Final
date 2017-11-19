package GameManagement.Validation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class InputValidatorTest {

    InputValidator iv= new InputValidator();

    @DataProvider(name="nameValidatorFalse")
    public Object[][] getData() {
        return new Object[][]{{"fdfs_ffsdf fds"},{"$"},{"("},{"%"},{"fd@ffds^fdfd"},{"fdsfs 34"},{"gfdg- 4"},{"-32"},
                {"fsdf/fdsf"},{"aBcD%eFgH"} };
    }

    @Test(dataProvider = "nameValidatorFalse")
    public void testValidatePlayerName(String s) throws Exception {

        assertFalse(iv.validatePlayerName(s));
    }

    @Test
    public void testValidateAdjacentSignsToWin() throws Exception {
    }

    @Test
    public void testValidateBoardDimensions() throws Exception {
    }

    @Test
    public void testValidateMove() throws Exception {
    }

    @Test
    public void testCheckIfTileTaken() throws Exception {
    }

}