package GameManagement.MoveManagement;

import Players.Player;

public class Move {

    int index;
    Player playerThatMadeTheMove;

    public Move(int index, Player playerThatMadeTheMove) {
        this.index = index;
        this.playerThatMadeTheMove = playerThatMadeTheMove;
    }

    public int getIndex() {
        return index;
    }
}
