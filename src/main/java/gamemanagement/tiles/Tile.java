package gamemanagement.tiles;

public class Tile {

    private String mark;
    private int number;
    private TakenTileSign takenTileSign;

    public Tile(int number) {
        mark = String.valueOf(number);
        this.number = number;
        takenTileSign = TakenTileSign.EMPTY;
    }

    public String getMark() {
        return mark;
    }

    @Override
    public String toString() {
        if (takenTileSign == TakenTileSign.EMPTY&mark.length()==1) return "|  " + mark + " |";
        else if (takenTileSign == TakenTileSign.EMPTY) return "| " + mark + " |";
        else return takenTileSign.toString();
    }

    public int getNumber() {
        return number;
    }

    public void setTakenTileSign(TakenTileSign takenTileSign) {
        this.takenTileSign = takenTileSign;
    }

    public TakenTileSign getTakenTileSign() {
        return takenTileSign;
    }
}
