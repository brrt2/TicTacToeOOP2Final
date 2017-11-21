package gameManagement;

import gameManagement.tiles.TakenTileSign;
import gameManagement.validation.Score;
import players.Player;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RefereeTest {

    Board board1 = new Board(3, 3);
    Score score;
    Player player1 = new Player("bartek", TakenTileSign.CROSS);
    Referee referee = new Referee(board1, 3);


    @DataProvider(name = "dp")
    public Object[][] getData() {
        return new Object[][]{{player1}};
    }


    @Test(dataProvider = "dp")
    public void testCheckIfWonHorizontally(Player player1) throws Exception {

        board1.markTile(1, TakenTileSign.CROSS);
        board1.markTile(2, TakenTileSign.CROSS);
        board1.markTile(3, TakenTileSign.CROSS);

        assertTrue(referee.checkIfWonHorizontally(player1));

    }

    @Test(dataProvider = "dp")
    public void testCheckDiagonal(Player player1) throws Exception {

        board1.markTile(1, TakenTileSign.CROSS);
        board1.markTile(5, TakenTileSign.CROSS);
        board1.markTile(9, TakenTileSign.CROSS);

        assertTrue(referee.checkDiagonal(player1, 9));
    }

    @Test(dataProvider = "dp")
    public void testCheckDiagonal2(Player player1) throws Exception {

        board1.markTile(3, TakenTileSign.CROSS);
        board1.markTile(5, TakenTileSign.CROSS);
        board1.markTile(7, TakenTileSign.CROSS);

        assertTrue(referee.checkDiagonal2(player1, 5));

    }

    @Test
    public void testCheckIfDraw() throws Exception {

        for (int i = 1; i < 10; i++) {
            board1.markTile(i, TakenTileSign.CROSS);
        }

        assertTrue(referee.checkIfDraw());

    }

    @Test(dataProvider = "dp")
    public void testCheckIfWonVertically(Player player1) throws Exception {
        board1.markTile(2, TakenTileSign.CROSS);
        board1.markTile(5, TakenTileSign.CROSS);
        board1.markTile(8, TakenTileSign.CROSS);

        assertTrue(referee.checkIfWonVertically(player1, 8));
    }

}