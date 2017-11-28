//package gameManagement;
//
//import gameManagement.boardTools.Height;
//import gameManagement.boardTools.TilesToWin;
//import gameManagement.boardTools.Width;
//import gameManagement.locale.Language;
//import gameManagement.moveManagement.Move;
//import gameManagement.tiles.TakenTileSign;
//import gameManagement.tiles.Tile;
//import org.testng.annotations.Test;
//import players.Player;
//import userInteraction.Output;
//import userInteraction.SystemOutOutput;
//import java.util.ArrayList;
//import java.util.List;
//
//public class GameTest {
//
//    @Test()
//    public void testObtaintileNumber() throws Exception {
//
//        Height height = new Height(5);
//        Width width = new Width(5);
//        List<Tile> list = new ArrayList<>(height.getValue()*width.getValue());
//        TilesToWin tilesToWin = new TilesToWin(3);
//        NumberOfMatches numberOfMatches = new NumberOfMatches(3);
//        PointsForWin pointsForWin = new PointsForWin(4);
//        Output output = new SystemOutOutput();
//        Language language = new Language("english.properties");
//        Player first = new Player("bartek", TakenTileSign.NOUGHT);
//        Player second = new Player("adam", TakenTileSign.CROSS);
//        Board board = new Board.Builder()
//                .height(height)
//                .column(width)
//                .playBoard(list)
//                .build();
//
//        Turn turn = new Turn(first,second);
//        Move move = new Move(5,first);
//        Game game = new Game(turn,board, tilesToWin,output,language,numberOfMatches,pointsForWin);
//
//    }
//
//}