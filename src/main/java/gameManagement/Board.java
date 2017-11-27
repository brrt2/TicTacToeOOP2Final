package gameManagement;

import com.sun.xml.internal.ws.server.sei.MessageFiller;
import gameManagement.boardTools.Height;
import gameManagement.boardTools.Width;
import gameManagement.moveManagement.Move;
import gameManagement.tiles.TakenTileSign;
import gameManagement.tiles.Tile;

import java.util.ArrayList;
import java.util.List;

public class Board implements Observer {

    private final Height row;
    private final Width column;
    private List<Tile> playBoard;
    private int moveCounter = 0;


    private Board(Builder builder) {
        row = builder.row;
        column=builder.column;
        playBoard=builder.playBoard;
        populateTheBoard();
    }

    @Override
    public void update(Move move) {
        playBoard.get(move.getIndex() - 1).setTakenTileSign(move.getPlayerThatMadeTheMove().getTakenTileSign());
        moveCounter++;

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

    public int getRow() {
        return row.getValue();
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


    public static class Builder {

        private Height row;
        private Width column;
        private List<Tile> playBoard;

        public Builder height(Height height){
            this.row=height;
            return this;
        }

        public Builder column(Width width){
            this.column=width;
            return this;
        }

        public Builder playBoard (List<Tile> list){
            this.playBoard=list;
            return this;
        }

        public Board build() {
            return new Board(this);
        }
    }


}