package gamemanagement.moveManagement;

import gamemanagement.tiles.TakenTileSign;
import org.testng.annotations.Test;
import players.Player;

import static org.testng.Assert.*;

public class MoveTest {

    Player player1 = new Player("bartek", TakenTileSign.CROSS);

    Move move = new Move(3,player1);

    @Test
    public void testGetIndex() throws Exception {
        assertEquals(move.getIndex(),3);
    }

    @Test
    public void testGetPlayerThatMadeTheMove() throws Exception {
        assertEquals(move.getPlayerThatMadeTheMove(),player1);
    }

}