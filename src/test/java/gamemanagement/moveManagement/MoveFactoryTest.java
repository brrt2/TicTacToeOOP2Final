package gamemanagement.moveManagement;

import gamemanagement.tiles.TakenTileSign;
import players.Player;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MoveFactoryTest {
    @Test
    public void testCreateMove() throws Exception {
        Player player = new Player("bartek",TakenTileSign.EMPTY);
        Move move = MoveFactory.createMove(4, player);
        assertEquals(move.getIndex(), 4);
    }

}