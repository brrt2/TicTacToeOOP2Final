package gamemanagement.tiles;

public enum TakenTileSign {

    EMPTY("e"),CROSS("x "),NOUGHT("o ");

    String mark;

    TakenTileSign(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "| "+mark+" |";
    }
}
