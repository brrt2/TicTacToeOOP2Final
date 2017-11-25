package gameManagement.boardTools;

public class BoardDimensions {

    private final Height height;
    private final Width width;
    private final int length;

    public BoardDimensions(Height height, Width width) {
        this.height = height;
        this.width = width;
        this.length=height.getValue()*width.getValue();
    }


    public int getHeight() {
        return height.getValue();
    }

    public int getWidth() {
        return width.getValue();
    }
}
