package gameManagement.moveManagement;

import players.Player;

public class Move {

    private int index;
    private Player playerThatMadeTheMove;

    public Move(int index, Player playerThatMadeTheMove) {
        this.index = index;
        this.playerThatMadeTheMove = playerThatMadeTheMove;
    }

    public int getIndex() {
        return index;
    }

    public Player getPlayerThatMadeTheMove() {
        return playerThatMadeTheMove;
    }
}
