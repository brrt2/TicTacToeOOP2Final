package gameManagement.tiles;

public class Tile {

    private String mark;
    private int number;
    private TileState tileState;

    public Tile(int number) {
        mark = String.valueOf(number);
        this.number = number;
        tileState = TileState.EMPTY;
    }

    public String getMark() {
        return mark;
    }

    @Override
    public String toString() {
        if (tileState == TileState.EMPTY) return "| " + mark + " |";
        else return tileState.toString();
    }

    public int getNumber() {
        return number;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
