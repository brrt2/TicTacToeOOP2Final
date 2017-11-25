package gameManagement;

import gameManagement.boardTools.Height;
import gameManagement.boardTools.Width;
import gameManagement.tiles.TakenTileSign;
import gameManagement.tiles.Tile;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Height row;
    private Width column;
    private List<Tile> playBoard;
    private int moveCounter = 0;


    public Board(Height row, Width column) {
        playBoard = new ArrayList<Tile>(row.getValue() * column.getValue());
        this.row = row;
        this.column = column;
        populateTheBoard();
    }

    public void populateTheBoard() {
        for (int i = 0; i < row.getValue() * column.getValue(); i++) {
            playBoard.add(new Tile(i + 1));
        }
    }

    public void markTile(int number, TakenTileSign takenTileSign) {
        playBoard.get(number - 1).setTakenTileSign(takenTileSign);
        moveCounter++;
    }

    public void clearBoard() {
        playBoard = new ArrayList<Tile>(row.getValue() * column.getValue());
        populateTheBoard();
    }

    public List<Tile> getPlayBoard() {
        return playBoard;
    }


    @Override
    public String toString() {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (Tile tile : playBoard) {
            sb.append(tile);
            count++;
            if (count == column.getValue()) {
                sb.append(" \n");
                count = 0;
            }
        }
        return sb.toString();
    }

    public int getColumn() {
        return column.getValue();
    }

    public int getMoveCounter() {
        return moveCounter;
    }

    public void setMoveCounter(int moveCounter) {
        this.moveCounter = moveCounter;
    }
}
