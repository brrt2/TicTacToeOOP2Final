package gamemanagement.moveManagement;

import players.Player;

public class Move {

    private int index;
    private Player playerThatMadeTheMove;

    Move(int index, Player playerThatMadeTheMove) {
        this.index = index;
        this.playerThatMadeTheMove = playerThatMadeTheMove;
    }

    public int getIndex() {
        return index;
    }

    Player getPlayerThatMadeTheMove() {
        return playerThatMadeTheMove;
    }
}
