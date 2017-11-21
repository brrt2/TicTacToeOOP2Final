package gameManagement.moveManagement;

import gameManagement.tiles.TakenTileSign;
import players.Player;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MoveHistoryTest {
    @Test
    public void testAddToArchive() throws Exception {
        Player player = new Player("bartek", TakenTileSign.EMPTY);
        Move move = MoveFactory.createMove(5, player);
        MoveHistory.addToArchive(move);
        assertFalse(MoveHistory.getMoveArchive().isEmpty());
    }

}