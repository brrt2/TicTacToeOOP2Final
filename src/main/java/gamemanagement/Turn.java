package gamemanagement;

import players.Player;

public class Turn {

    private Player firstPlayer;
    private Player secondPlayer;
    private Player currentPlayer;

    public Turn(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void switchCurrentPlayer() {
        if (currentPlayer.equals(firstPlayer))
            currentPlayer = secondPlayer;
        else currentPlayer = firstPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
