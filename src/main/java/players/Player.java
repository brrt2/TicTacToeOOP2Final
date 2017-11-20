package players;

import gameManagement.tiles.TileState;

public class Player {

    private String name;
    private String playerSign;
    private TileState tileState;

    public Player(String name, String playerSign, TileState tileState) {
        this.name = name;
        this.playerSign = playerSign;
    }

    public String getPlayerSign() {
        return playerSign;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
