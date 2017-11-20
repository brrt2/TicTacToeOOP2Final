package gameManagement;

import gameManagement.tiles.Tile;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BoardTest {


    Board board = new Board(4,4);


    @DataProvider(name="markTile")
    public Object[][] getData() {
        return new Object[][]{{1,"x"},{2,"x"},{3,"x"},{4,"x"},{5,"x"},{6,"x"},{7,"x"},{8,"x"},{9,"x"},{10,"x"},{11,"x"},
                {12,"x"},{13,"x"},{14,"x"},{15,"x"},{16,"x"}};
    }

    @DataProvider(name="populateBoard")
    public Object [][] getData1(){
        return new Object[][]{{1},{2},{3},{4},{5},{6},{7},{8},{9},{10},{11},{12},{13},{14},{15},{16}};
    }


    @Test(dataProvider = "populateBoard")
    public void testPopulateTheBoard(int number) throws Exception {
            board.getPlayBoard().add(new Tile(number));
            assertEquals(board.getPlayBoard().get(number-1).getNumber(),number);
    }

    @Test(dataProvider = "markTile")
    public void testMarkTile(int number, String s) throws Exception {
        board.populateTheBoard();
        board.markTile(number,s);
        assertEquals(board.getPlayBoard().get(number-1).getMark(),"x");
    }

    @Test(dataProvider = "markTile")
    public void testClearBoard(int number,String s) throws Exception {
        board.populateTheBoard();
        board.markTile(number,s);
        board.clearBoard();
        assertFalse(board.getPlayBoard().get(number-1).getMark().equals("x"));
    }

}