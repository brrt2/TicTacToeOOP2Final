package gamemanagement.moveManagement;

import gamemanagement.tiles.TakenTileSign;
import players.Player;
import org.testng.annotations.Test;

public class MoveHistoryTest {

    Player player = new Player("bartek", TakenTileSign.EMPTY);
    Move move = MoveFactory.createMove(5, player);

    @Test
    public void testAddToArchive() throws Exception {
        Player player = new Player("bartek", TakenTileSign.EMPTY);
        Move move = MoveFactory.createMove(5, player);
        MoveHistory.addToArchive(move);
        //assertFalse(MoveHistory.getMoveArchive().isEmpty());
    }

}