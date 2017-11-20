package gameManagement.tiles;

public enum TileState {

    EMPTY("e"),CROSS("x"),NOUGHT("o");

    String mark;

    TileState(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "| "+mark+" |";
    }
}
