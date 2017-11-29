package gamemanagement.moveManagement;

import players.Player;

public class MoveFactory {

    public static Move createMove(int tileNumber, Player currentPlayer) {
        return new Move(tileNumber, currentPlayer);
    }

}
