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
////        Board playBoard = new Board(3,3);
////    }
//
//    @Test
//    public void testShowBoard() throws Exception {
//        Board playBoard = new Board(3,3);
//        assertFalse(playBoard.playBoard.isEmpty());
//        assertTrue(playBoard.playBoard.get(2)=='e');
//    }
//
////    @Test
////    public void testMarkField() throws Exception {
////        Board playBoard = new Board(3,3);
////        playBoard.markField(3);
////        assertEquals(playBoard.playBoard.get(3),new Character('x'));
////    }
//
//    @Test
//    public void testClearBoard() throws Exception {
//        Board playBoard = new Board(3,3);
//        playBoard.clearBoard();
//        assertTrue(playBoard.playBoard.isEmpty());
//    }
//
//}