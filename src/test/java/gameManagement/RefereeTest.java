package gameManagement;

import gameManagement.boardTools.Height;
import gameManagement.boardTools.TilesToWin;
import gameManagement.boardTools.Width;
import gameManagement.tiles.TakenTileSign;
import gameManagement.tiles.Tile;
import players.Player;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class RefereeTest {


    Player player1 = new Player("bartek", TakenTileSign.CROSS);

    @DataProvider(name = "horizontalCheck")
    public Object[][] getData() {

        return new Object[][]{
                {3, 3, 3, new int[]{1, 2, 3}},
                {3, 3, 3, new int[]{4, 5, 6}},
                {3, 3, 3, new int[]{7, 8, 9}},
                {4, 4, 4, new int[]{1, 2, 3, 4}},
                {4, 4, 4, new int[]{5, 6, 7, 8}},
                {4, 4, 4, new int[]{9, 10, 11, 12}},
                {4, 4, 4, new int[]{13, 14, 15, 16}},
                {5, 5, 5, new int[]{1, 2, 3, 4, 5}},
                {5, 5, 5, new int[]{6, 7, 8, 9, 10}},
                {5, 5, 5, new int[]{11, 12, 13, 14, 15}},
                {5, 5, 5, new int[]{16, 17, 18, 19, 20}},
                {5, 5, 5, new int[]{21, 22, 23, 24, 25}},
                {6, 6, 5, new int[]{1, 2, 3, 4, 5}},
                {6, 6, 5, new int[]{6, 7, 8, 9, 10}},
                {6, 6, 5, new int[]{13, 14, 15, 16, 17}},
                {6, 6, 5, new int[]{19, 20, 21, 22, 23}},
                {6, 6, 5, new int[]{25, 26, 27, 28, 29}},
                {6, 6, 5, new int[]{31, 32, 33, 34, 35}},
                {7, 7, 7, new int[]{1, 2, 3, 4, 5, 6, 7}},
                {7, 7, 7, new int[]{8, 9, 10, 11, 12, 13, 14}},
                {7, 7, 7, new int[]{15, 16, 17, 18, 19, 20, 21}},
                {7, 7, 7, new int[]{22, 23, 24, 25, 26, 27, 28}},
                {7, 7, 7, new int[]{29, 30, 31, 32, 33, 34, 35}},
                {7, 7, 7, new int[]{36, 37, 38, 39, 40, 41, 42}},
                {7, 7, 7, new int[]{43, 44, 45, 46, 47, 48, 49}},
                {7, 5, 5, new int[]{1, 2, 3, 4, 5}},
                {7, 10, 5, new int[]{11, 12, 13, 14, 15}},
                {15, 6, 5, new int[]{1, 2, 3, 4, 5, 6}},
                {25, 8, 5, new int[]{1, 2, 3, 4, 5, 6, 7, 8}},
                {25, 8, 5, new int[]{9, 10, 11, 12, 13, 14, 15, 16}},
                {17, 3, 3, new int[]{4, 5, 6}},
        };
    }


    @DataProvider(name = "diagonalCheckLtR")
    public Object[][] getData2() {

        return new Object[][]{
                {3, 3, 3, new int[]{1, 5, 9}},
                {4, 4, 3, new int[]{1, 6, 11}},
                {4, 4, 3, new int[]{5, 10, 15}},
                {5, 5, 3, new int[]{1, 7, 13}},
                {5, 5, 3, new int[]{2, 8, 14}},
                {5, 5, 3, new int[]{3, 9, 15}},
                {5, 5, 3, new int[]{6, 12, 18}},
                {5, 5, 3, new int[]{11, 17, 23}},
                {5, 5, 4, new int[]{1, 7, 13, 19}},
                {5, 5, 3, new int[]{6, 12, 18, 24}},
                {6, 6, 3, new int[]{1, 8, 15}},
                {6, 6, 3, new int[]{3, 10, 17}},
                {6, 6, 3, new int[]{7, 14, 21}},
                {7, 7, 3, new int[]{1, 9, 17}},
                {7, 7, 3, new int[]{2, 10, 18}},
                {7, 7, 3, new int[]{3, 11, 19}},
                {3, 7, 3, new int[]{5, 13, 21}},
                {8, 6, 4, new int[]{3, 10, 17, 24}},
                {8, 6, 3, new int[]{1, 8, 15, 22}},
                {7, 4, 3, new int[]{6, 11, 16}},
                {7, 4, 3, new int[]{5, 10, 15}},
                {5, 3, 3, new int[]{7, 11, 15}},
                {5, 3, 3, new int[]{4, 8, 12}},
        };
    }

    @DataProvider(name = "diagonalCheckRtL")
    public Object[][] getData3() {
        return new Object[][]{

                {3, 3, 3, new int[]{3, 5, 7}},
                {4, 4, 3, new int[]{4, 7, 10}},
                {4, 4, 3, new int[]{8, 11, 14}},
                {4, 4, 3, new int[]{3, 6, 9}},
                {5, 5, 3, new int[]{3, 7, 11}},
                {5, 5, 3, new int[]{4, 8, 12}},
                {6, 6, 3, new int[]{4, 9, 14}},
                {6, 6, 3, new int[]{5, 10, 15}},
                {6, 6, 3, new int[]{6, 11, 16}},
                {6, 6, 3, new int[]{12, 17, 22}},
                {3, 7, 3, new int[]{7, 13, 19}},
                {3, 7, 3, new int[]{6, 12, 18}},
                {3, 7, 3, new int[]{3, 9, 15}},
                {3, 7, 3, new int[]{4, 10, 16}},

        };
    }


    @DataProvider(name = "CheckIfDraw")
    public Object[][] getData4() {
        return new Object[][]{

                {3, 3, 3, new int[]{1,2,3,4,5,6,7,8,9}},
                {4, 4, 3, new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}},
//                {4, 4, 3, new int[]{8, 11, 14}},
//                {4, 4, 3, new int[]{3, 6, 9}},
//                {5, 5, 3, new int[]{3, 7, 11}},
//                {5, 5, 3, new int[]{4, 8, 12}},
//                {6, 6, 3, new int[]{4, 9, 14}},
//                {6, 6, 3, new int[]{5, 10, 15}},
//                {6, 6, 3, new int[]{6, 11, 16}},
//                {6, 6, 3, new int[]{12, 17, 22}},
//                {3, 7, 3, new int[]{7, 13, 19}},
//                {3, 7, 3, new int[]{6, 12, 18}},
//                {3, 7, 3, new int[]{3, 9, 15}},
//                {3, 7, 3, new int[]{4, 10, 16}},

        };
    }


    @DataProvider(name = "CheckIfWonVertically")
    public Object[][] getData5() {
        return new Object[][]{

                {3, 3, 3, new int[]{1,4,7}},
                {4, 4, 3, new int[]{1,5,9}},
//                {4, 4, 3, new int[]{8, 11, 14}},
//                {4, 4, 3, new int[]{3, 6, 9}},
//                {5, 5, 3, new int[]{3, 7, 11}},
//                {5, 5, 3, new int[]{4, 8, 12}},
//                {6, 6, 3, new int[]{4, 9, 14}},
//                {6, 6, 3, new int[]{5, 10, 15}},
//                {6, 6, 3, new int[]{6, 11, 16}},
//                {6, 6, 3, new int[]{12, 17, 22}},
//                {3, 7, 3, new int[]{7, 13, 19}},
//                {3, 7, 3, new int[]{6, 12, 18}},
//                {3, 7, 3, new int[]{3, 9, 15}},
//                {3, 7, 3, new int[]{4, 10, 16}},

        };
    }


    @Test(dataProvider = "horizontalCheck")
    public void testCheckIfWonHorizontally(int row, int column, int tilesToWin, int[] toMark) throws Exception {
        Height h = new Height(row);
        Width w = new Width(column);
        List<Tile> list = new ArrayList<>();
        TilesToWin tilesToWin1 = new TilesToWin(tilesToWin);
        NumberOfMatches numberOfMatches = new NumberOfMatches(3);
        PointsForWin pointsForWin = new PointsForWin(3);

        Board board = new Board.Builder()
                .height(h)
                .column(w)
                .playBoard(list)
                .build();
        Referee referee = new Referee(board, tilesToWin1, numberOfMatches, pointsForWin);
        for (int i = 0; i < toMark.length; i++) {
            board.markTile(toMark[i], player1.getTakenTileSign());
        }

        assertTrue(referee.checkIfWonHorizontally(player1));
    }

    @Test(dataProvider = "diagonalCheckLtR")
    public void testCheckDiagonalLeftToRight(int row, int column, int tilesToWin, int[] toMark) throws Exception {
        Height h = new Height(row);
        Width w = new Width(column);
        List<Tile> list = new ArrayList<>();
        TilesToWin tilesToWin1 = new TilesToWin(tilesToWin);
        NumberOfMatches numberOfMatches = new NumberOfMatches(3);
        PointsForWin pointsForWin = new PointsForWin(3);

        Board board = new Board.Builder()
                .height(h)
                .column(w)
                .playBoard(list)
                .build();
        Referee referee = new Referee(board, tilesToWin1, numberOfMatches, pointsForWin);

        for (int i = 0; i < toMark.length; i++) {
            board.markTile(toMark[i], player1.getTakenTileSign());
        }
        assertTrue(referee.checkDiagonalLeftToRight(player1, toMark[toMark.length - 1]));
    }

    @Test(dataProvider = "diagonalCheckRtL")
    public void testCheckDiagonalRightToLeft(int row, int column, int tilesToWin, int[] toMark) throws Exception {


        Height h = new Height(row);
        Width w = new Width(column);
        List<Tile> list = new ArrayList<>();
        TilesToWin tilesToWin1 = new TilesToWin(tilesToWin);
        NumberOfMatches numberOfMatches = new NumberOfMatches(3);
        PointsForWin pointsForWin = new PointsForWin(3);

        Board board = new Board.Builder()
                .height(h)
                .column(w)
                .playBoard(list)
                .build();
        Referee referee = new Referee(board, tilesToWin1, numberOfMatches, pointsForWin);


        for (int i = 0; i < toMark.length; i++) {
            board.markTile(toMark[i], player1.getTakenTileSign());
        }
        assertTrue(referee.checkDiagonalRL(player1, toMark[toMark.length - 1]));
    }


    @Test(dataProvider = "CheckIfDraw")
    public void testCheckIfDraw(int row, int column, int tilesToWin, int[] toMark) throws Exception {

        Height h = new Height(row);
        Width w = new Width(column);
        List<Tile> list = new ArrayList<>();
        TilesToWin tilesToWin1 = new TilesToWin(tilesToWin);
        NumberOfMatches numberOfMatches = new NumberOfMatches(3);
        PointsForWin pointsForWin = new PointsForWin(3);

        Board board = new Board.Builder()
                .height(h)
                .column(w)
                .playBoard(list)
                .build();
        Referee referee = new Referee(board, tilesToWin1, numberOfMatches, pointsForWin);


        for (int i = 0; i < toMark.length; i++) {
            board.markTile(toMark[i], TakenTileSign.CROSS);
        }
        assertTrue(referee.checkIfDraw());
    }

    @Test(dataProvider = "CheckIfWonVertically")
    public void testCheckIfWonVertically(int row, int column, int tilesToWin, int[] toMark) throws Exception {

        Height h = new Height(row);
        Width w = new Width(column);
        List<Tile> list = new ArrayList<>();
        TilesToWin tilesToWin1 = new TilesToWin(tilesToWin);
        NumberOfMatches numberOfMatches = new NumberOfMatches(3);
        PointsForWin pointsForWin = new PointsForWin(3);

        Board board = new Board.Builder()
                .height(h)
                .column(w)
                .playBoard(list)
                .build();
        Referee referee = new Referee(board, tilesToWin1, numberOfMatches, pointsForWin);

        for (int i = 0; i < toMark.length; i++) {
            board.markTile(toMark[i], TakenTileSign.CROSS);
        }

        assertTrue(referee.checkIfWonVertically(player1,toMark[toMark.length - 1]));
    }

}

