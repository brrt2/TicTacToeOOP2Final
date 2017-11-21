package gameManagement.validation;

import gameManagement.tiles.TakenTileSign;
import players.Player;

public class Score {

    private int crossPlayerPoints = 0;
    private int noughtPlayerPoints = 0;
    private int roundNumber;


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
        roundNumber++;
        if (currentPlayer.getTakenTileSign().equals(TakenTileSign.CROSS)) {
            crossPlayerPoints+=3;
        } else if (currentPlayer.getTakenTileSign().equals(TakenTileSign.NOUGHT)) {
            noughtPlayerPoints+=3;
        }
    }

    public void increaseScoreDraw(){
        roundNumber++;
        crossPlayerPoints++;
        noughtPlayerPoints++;
    }

    public void getCurrentScore() {
        System.out.println("Player X has : " + crossPlayerPoints);
        System.out.println("Player O has : " + noughtPlayerPoints);
    }

    public void resetScore() {
        crossPlayerPoints = 0;
        noughtPlayerPoints = 0;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }
}
