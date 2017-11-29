package gamemanagement;

import gamemanagement.configuration.Height;
import gamemanagement.configuration.Width;
import gamemanagement.tiles.TakenTileSign;
import gamemanagement.tiles.Tile;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class BoardTest {

    private Height h = new Height(10);
    private Width w = new Width(10);
    private List<Tile> list = new ArrayList<>();


    Board board = new Board.Builder()
            .height(h)
            .column(w)
            .playBoard(list)
            .build();

    @DataProvider(name = "markTile")
    public Object[][] getData() {
        return new Object[][]{{1}, {2}, {43}, {4}, {32}, {6}, {7}, {8}, {80}, {72}, {11},
                {49,}, {13}, {53}, {15}, {16}, {22}, {62}, {73}, {86}, {92}};
    }

    @DataProvider(name = "populateBoard")
    public Object[][] getData1() {
        return new Object[][]{{1}, {2}, {3}, {26}, {5}, {48}, {7}, {8}, {53}, {10}, {11}, {35}, {13}, {14}, {15}, {16}, {17}, {23}, {21}, {58}
                , {69}, {70}, {36}, {92}, {95}, {89}
        };
    }


    @Test(dataProvider = "populateBoard")
    public void testPopulateTheBoard(int number) throws Exception {
        board.getPlayBoard().add(new Tile(number));
        assertEquals(board.getPlayBoard().get(number - 1).getNumber(), number);
    }

    @Test(dataProvider = "markTile")
    public void testMarkTile(int number) throws Exception {
        board.populateTheBoard();
        board.markTile(number, TakenTileSign.CROSS);
        assertEquals(board.getPlayBoard().get(number - 1).getTakenTileSign(), TakenTileSign.CROSS);
    }

    @Test(dataProvider = "markTile")
    public void testClearBoard(int number) throws Exception {
        board.populateTheBoard();
        board.markTile(number, TakenTileSign.CROSS);
        board.clearBoard();
        assertFalse(board.getPlayBoard().get(number - 1).getMark().equals("x"));
    }

}