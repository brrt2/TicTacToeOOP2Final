package players;

import gameManagement.tiles.TakenTileSign;

public class Player {

    private String name;
    private TakenTileSign takenTileSign;

    public Player(String name,TakenTileSign takenTileSign) {
        this.name = name;
        this.takenTileSign=takenTileSign;
    }

    public String getName() {
        return name;
    }

    public TakenTileSign getTakenTileSign() {
        return takenTileSign;
    }

    public void setTakenTileSign(TakenTileSign takenTileSign) {
        this.takenTileSign = takenTileSign;
    }

    @Override
    public String toString() {
        return name;
    }
}
