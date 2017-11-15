//package GameManagement;
//
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import static org.testng.Assert.*;
//
//public class BoardTest {
//
////    @BeforeTest
////    public void init(){
////        Board board = new Board(3,3);
////    }
//
//    @Test
//    public void testShowBoard() throws Exception {
//        Board board = new Board(3,3);
//        assertFalse(board.playBoard.isEmpty());
//        assertTrue(board.playBoard.get(2)=='e');
//    }
//
////    @Test
////    public void testMarkField() throws Exception {
////        Board board = new Board(3,3);
////        board.markField(3);
////        assertEquals(board.playBoard.get(3),new Character('x'));
////    }
//
//    @Test
//    public void testClearBoard() throws Exception {
//        Board board = new Board(3,3);
//        board.clearBoard();
//        assertTrue(board.playBoard.isEmpty());
//    }
//
//}