package gameManagement.moveManagement;

import gameManagement.tiles.TileState;
import players.Player;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MoveHistoryTest {
    @Test
    public void testAddToArchive() throws Exception {
        Player player = new Player("bartek", "x", TileState.EMPTY);
        Move move = MoveFactory.createMove(5, player);
        MoveHistory.addToArchive(move);
        assertFalse(MoveHistory.getMoveArchive().isEmpty());
    }

}