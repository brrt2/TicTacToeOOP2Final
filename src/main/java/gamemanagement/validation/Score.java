package gamemanagement.validation;

import gamemanagement.configuration.NumberOfRounds;
import gamemanagement.configuration.PointsForWin;
import gamemanagement.tiles.TakenTileSign;
import players.Player;

public class Score {

    private int crossPlayerPoints = 0;
    private int noughtPlayerPoints = 0;
    private int roundNumber;
    private NumberOfRounds numberOfRounds;
    private PointsForWin pointsForWin;

    public Score(NumberOfRounds numberOfRounds, PointsForWin pointsForWin) {
        this.numberOfRounds = numberOfRounds;
        this.pointsForWin=pointsForWin;
    }

    public int getCrossPlayerPoints() {
        return crossPlayerPoints;
    }

    public int getNoughtPlayerPoints() {
        return noughtPlayerPoints;
    }

    public void increaseScore(Player currentPlayer) {
        roundNumber++;
        if (currentPlayer.getTakenTileSign().equals(TakenTileSign.CROSS)) {
            crossPlayerPoints+=pointsForWin.getValue();
        } else if (currentPlayer.getTakenTileSign().equals(TakenTileSign.NOUGHT)) {
            noughtPlayerPoints+=pointsForWin.getValue();
        }
    }

    public void swapScores(){
        int temp=crossPlayerPoints;
        crossPlayerPoints=noughtPlayerPoints;
        noughtPlayerPoints=temp;
    }

    public void increaseScoreDraw(){
        roundNumber++;
        crossPlayerPoints++;
        noughtPlayerPoints++;
    }

    public void resetScore() {
        crossPlayerPoints = 0;
        noughtPlayerPoints = 0;
    }

    public int getRoundNumber() {
        return roundNumber;
    }


    public NumberOfRounds getNumberOfRounds() {
        return numberOfRounds;
    }

}
