package GameManagement.MoveManagement;

import Players.Player;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MoveFactoryTest {
    @Test
    public void testCreateMove() throws Exception {
        Player player = new Player("bartek","x");
        Move move =MoveFactory.createMove(4,player);
        assertEquals(move.getIndex(),4);
    }

}