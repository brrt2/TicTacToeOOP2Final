package gameManagement.validation;

import players.Player;

public class Score {

    private int crossPlayerPoints=0;
    private int noughtPlayerPoints=0;


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

    public void increaseScore(Player currentPlayer){
        if(currentPlayer.getPlayerSign().equals("x")){
            crossPlayerPoints++;
        }
        else if(currentPlayer.getPlayerSign().equals("o")){
            noughtPlayerPoints++;
        }
    }

    public void getCurrentScore(){
        System.out.println("Player X has : " +crossPlayerPoints);
        System.out.println("Player O has : " + noughtPlayerPoints);
    }

    public void resetScore() {
        crossPlayerPoints=0;
        noughtPlayerPoints=0;
    }

}
