package GameManagement;

public class Tile {

    String mark;
    int number;

    public Tile(int number) {
        mark = String.valueOf(number);
        this.number = number;
    }

    public String getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "| "+ mark + " |";
    }
}
