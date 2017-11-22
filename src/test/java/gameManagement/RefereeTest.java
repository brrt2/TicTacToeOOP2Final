package gameManagement;

import gameManagement.tiles.TakenTileSign;
import gameManagement.validation.Score;
import players.Player;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RefereeTest {


    Player player1 = new Player("bartek", TakenTileSign.CROSS);

    @DataProvider(name = "dp")
    public Object[][] getData() {

        return new Object[][]{
                {3,3,3,new int[]{1,2,3}},
                {3,3,3,new int[]{4,5,6}},
                {3,3,3,new int[]{7,8,9}},
                {4,4,4,new int[]{1,2,3,4}},
                {4,4,4,new int[]{5,6,7,8}},
                {4,4,4,new int[]{9,10,11,12}},
                {4,4,4,new int[]{13,14,15,16}},
                {5,5,5,new int[]{1,2,3,4,5}},
                {5,5,5,new int[]{6,7,8,9,10}},
                {5,5,5,new int[]{11,12,13,14,15}},
                {5,5,5,new int[]{16,17,18,19,20}},
                {5,5,5,new int[]{21,22,23,24,25}},
                {6,6,5,new int[]{1,2,3,4,5}},
                {6,6,5,new int[]{6,7,8,9,10}},
                {6,6,5,new int[]{13,14,15,16,17}},
                {6,6,5,new int[]{19,20,21,22,23}},
                {6,6,5,new int[]{25,26,27,28,29}},
                {6,6,5,new int[]{31,32,33,34,35}},
                {7,7,7,new int[]{1,2,3,4,5,6,7}},
                {7,7,7,new int[]{8,9,10,11,12,13,14}},
                {7,7,7,new int[]{15,16,17,18,19,20,21}},
                {7,7,7,new int[]{22,23,24,25,26,27,28}},
                {7,7,7,new int[]{29,30,31,32,33,34,35}},
                {7,7,7,new int[]{36,37,38,39,40,41,42}},
                {7,7,7,new int[]{43,44,45,46,47,48,49}},
                {7,5,5,new int[]{1,2,3,4,5}},
                {7,10,5,new int[]{11,12,13,14,15}},
                {15,6,5,new int[]{1,2,3,4,5,6}},
                {25,8,5,new int[]{1,2,3,4,5,6,7,8}},
                {25,8,5,new int[]{9,10,11,12,13,14,15,16}},
                {17,3,3,new int[]{4,5,6}},
        };
    }

    @Test(dataProvider = "dp")
    public void testCheckIfWonHorizontally(int row,int column,int tilesToWin, int[]toMark) throws Exception {

        Board board1 = new Board(row, column);
        Referee referee = new Referee(board1, tilesToWin);
        for(int i=0; i<toMark.length;i++) {
            board1.markTile(toMark[i], player1.getTakenTileSign());
        }

        assertTrue(referee.checkIfWonHorizontally(player1));
    }

//    @Test
//    public void testCheckDiagonalLeftToRight() throws Exception {
//
//        board1.markTile(1, TakenTileSign.CROSS);
//        board1.markTile(5, TakenTileSign.CROSS);
//        board1.markTile(9, TakenTileSign.CROSS);
//
//        assertTrue(referee.checkDiagonalLeftToRight(player1, 9));
//    }
//
//    @Test
//    public void testCheckDiagonalRightToLeft() throws Exception {
//
//        board1.markTile(3, TakenTileSign.CROSS);
//        board1.markTile(5, TakenTileSign.CROSS);
//        board1.markTile(7, TakenTileSign.CROSS);
//
//        assertTrue(referee.checkDiagonal2(player1, 5));
//
//    }
//
//    @Test
//    public void testCheckIfDraw() throws Exception {
//
//        for (int i = 1; i < 10; i++) {
//            board1.markTile(i, TakenTileSign.CROSS);
//        }
//
//        assertTrue(referee.checkIfDraw());
//
//    }
//
//    @Test
//    public void testCheckIfWonVertically() throws Exception {
//        board1.markTile(2, TakenTileSign.CROSS);
//        board1.markTile(5, TakenTileSign.CROSS);
//        board1.markTile(8, TakenTileSign.CROSS);
//
//        assertTrue(referee.checkIfWonVertically(player1, 8));
//    }

}