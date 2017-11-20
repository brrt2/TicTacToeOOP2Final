package Players;

public class Player {

    private String name;
    private String playerSign;

    public Player(String name,String playerSign) {
        this.name = name;
        this.playerSign=playerSign;
    }

    public String getPlayerSign() {
        return playerSign;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  name;
    }
}
