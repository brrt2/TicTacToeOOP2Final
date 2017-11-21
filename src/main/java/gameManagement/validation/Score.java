package gameManagement.validation;

import gameManagement.tiles.TakenTileSign;
import players.Player;

public class Score {

    private int crossPlayerPoints = 0;
    private int noughtPlayerPoints = 0;


    public int getCrossPlayerPoints() {
        return crossPlayerPoints;
    }

    public void setCrossPlayerPoints(int crossPlayerPoints) {
        this.crossPlayerPoints = crossPlayerPoints;
    }

    public int getNoughtPlayerPoints() {
        return noughtPlayerPoints;
    }

    public void setNoughtPlayerPoints(int noughtPlayerPoints) {
        this.noughtPlayerPoints = noughtPlayerPoints;
    }

    public void increaseScore(Player currentPlayer) {
        if (currentPlayer.getTakenTileSign().equals(TakenTileSign.CROSS)) {
            crossPlayerPoints++;
        } else if (currentPlayer.getTakenTileSign().equals(TakenTileSign.NOUGHT)) {
            noughtPlayerPoints++;
        }
    }

    public void getCurrentScore() {
        System.out.println("Player X has : " + crossPlayerPoints);
        System.out.println("Player O has : " + noughtPlayerPoints);
    }

    public void resetScore() {
        crossPlayerPoints = 0;
        noughtPlayerPoints = 0;
    }

}
