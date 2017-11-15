package GameManagement;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

//@Test
//public class RefereeTest {
//
//    public void testCheckIfWonHorizontally() throws Exception {
//        Board board = BoardFactory.createBoard(3,3);
//        Referee referee = new Referee(board);
//        MoveValidator mv = new MoveValidator(board);
//        List<Character> list = board.getPlayBoard();
//        Move move = new Move(1);
//        Move move2 = new Move(2);
//        Move move3 = new Move(3);
//        mv.markTile(move);
//        mv.markTile(move2);
//        mv.markTile(move3);
//        assertTrue(referee.checkifWonHorizontally(move3,3));
//    }
//
//
//    public void testCheckIfWonVertically() throws Exception {
//        Board board = BoardFactory.createBoard(3,3);
//        Referee referee = new Referee(board);
//        MoveValidator mv = new MoveValidator(board);
//        List<Character> list = board.getPlayBoard();
//        Move move = new Move(1);
//        Move move2 = new Move(2);
//        Move move3 = new Move(3);
//        mv.markTile(move);
//        mv.markTile(move2);
//        mv.markTile(move3);
//        assertTrue(referee.checkifWonHorizontally(move3,3));
//    }
//
//
//
//    public void testCheckIfWonDiagonallyLeftToRight() throws Exception {
//        Board board = BoardFactory.createBoard(3,3);
//        Referee referee = new Referee(board);
//        MoveValidator mv = new MoveValidator(board);
//        List<Character> list = board.getPlayBoard();
//        Move move = new Move(1);
//        Move move2 = new Move(2);
//        Move move3 = new Move(3);
//        mv.markTile(move);
//        mv.markTile(move2);
//        mv.markTile(move3);
//        assertTrue(referee.checkifWonHorizontally(move3,3));
//    }
//
//}