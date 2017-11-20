package GameManagement.MoveManagement;

import GameManagement.MoveManagement.Move;
import Players.Player;

public class MoveFactory {

    public static Move createMove(int tileNumber, Player currentPlayer){
        return new Move(tileNumber,currentPlayer);
    }

}
