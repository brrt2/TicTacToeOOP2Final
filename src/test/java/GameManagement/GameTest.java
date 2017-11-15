package GameManagement;

import Players.Player;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ExpectedExceptionsAnnotation;

import static org.testng.Assert.*;

@Test
public class GameTest {
    Player player1 = new Player("Jan","x");
    Player player2 = new Player("Adam","o");
    Game game = new Game(player1,player2,3,3,3 );

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void IfOutsideBoardThenException () {


            //when
        game.setCurrentPlayer(player1);
        game.board.markTile(5,1,"x");
        // then exception
    }


    @Test(expectedExceptions = IllegalArgumentException.class)
    public void IfTileAlreadyTakenThenException () {


        //when
        game.setCurrentPlayer(player1);
        game.board.markTile(1,1,"x");
        game.board.markTile(1,1,"x");
        // then  exception
    }

    public void CheckIfWonHorizontallyTest() throws Exception {
        //when
        game.setCurrentPlayer(player1);
        game.board.markTile(1,3,"x");
        game.board.markTile(2,2,"x");
        game.board.markTile(2,3,"x");
        game.board.markTile(3,3,"x");
        //then
        assertTrue(game.checkIfWonHoritontally());
    }


    public void CheckIfWonVerticallyTest() throws Exception {


        game.setCurrentPlayer(player1);
        game.board.markTile(1,3,"x");
        game.board.markTile(2,3,"x");
        game.board.markTile(3,3,"x");

        assertTrue(game.checkIfWonVertically());
    }




}