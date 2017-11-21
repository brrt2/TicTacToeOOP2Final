package gameManagement;

import gameManagement.tiles.TakenTileSign;
import gameManagement.tiles.Tile;
import gameManagement.validation.Score;
import players.Player;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    private Board board;
    private int tilesToWin;
    private Score score;


    public Referee(Board board, int tilesToWin) {
        this.board = board;
        this.tilesToWin = tilesToWin;
        score = new Score();
    }

    public boolean checkIfWonHorizontally(Player currentPlayer) {
        int counter = 0;
        for (int i = 0; i < board.getPlayBoard().size(); i++) {
            if (currentPlayer.getTakenTileSign().equals(board.getPlayBoard().get(i).getTakenTileSign())) counter++;
            else counter = 0;
            if (counter == tilesToWin) {
                score.increaseScore(currentPlayer);
                board.setMoveCounter(0);
                return true;
            }
        }
        return false;
    }


    public boolean checkDiagonal(Player currentPlayer, int number) {
        int counter = 0;
        for (int i = number - 1; i >= 0; i -= board.getColumn() + 1) {
            if (currentPlayer.getTakenTileSign().equals(board.getPlayBoard().get(i).getTakenTileSign()))
                counter++;
            else if (counter > 2) break;
        }
        for (int i = number - 1; i < board.getPlayBoard().size(); i += board.getColumn() + 1) {
            if (currentPlayer.getTakenTileSign().equals(board.getPlayBoard().get(i).getTakenTileSign())) counter++;
            else counter = 0;
            if (counter - 1 == tilesToWin) {
                score.increaseScore(currentPlayer);
                board.setMoveCounter(0);
                return true;
            }
        }
        return false;
    }

public boolean checkDiagonal3(Player currentPlayer,int index) {
    int counter = 0;
    ArrayList<Tile> tilesOnDiagonal = new ArrayList<>();
    while (index - board.getColumn() - 1 > 0) {
        index = index - board.getColumn() - 1;
        if (index % board.getColumn() == 1) {
            break;
        }
    }
    while (index <= board.getPlayBoard().size()) {
        tilesOnDiagonal.add(board.getPlayBoard().get(index - 1));
        index += (board.getColumn() + 1);
    }
    for (int i = 0; i < tilesOnDiagonal.size(); i++) {
        if (currentPlayer.getTakenTileSign().equals(tilesOnDiagonal.get(i).getTakenTileSign())) counter++;
        if (counter == tilesToWin) {
            score.increaseScore(currentPlayer);
            board.setMoveCounter(0);
            return true;
        }
    }
    return false;
}

    public boolean checkDiagonal4(Player currentPlayer,int index) {
        int counter = 0;
        ArrayList<Tile> tilesOnDiagonal2 = new ArrayList<>();
        while (index - board.getColumn() - 1 > 0) {
            index = index - board.getColumn() +1;
            if (index % board.getColumn() == 0) {
                break;
            }
        }
        while (index <= board.getPlayBoard().size()) {
            tilesOnDiagonal2.add(board.getPlayBoard().get(index - 1));
            index += (board.getColumn() + 1);
        }
        for (int i = 0; i < tilesOnDiagonal2.size(); i++) {
            if (currentPlayer.getTakenTileSign().equals(tilesOnDiagonal2.get(i).getTakenTileSign())) counter++;
            if (counter == tilesToWin) {
                score.increaseScore(currentPlayer);
                board.setMoveCounter(0);
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonal2(Player currentPlayer, int number) {
       int counter = 0;
       for (int i = number - 1; i > 0; i -= board.getColumn() - 1) {
           if (currentPlayer.getTakenTileSign().equals(board.getPlayBoard().get(i).getTakenTileSign()))
               counter++;
           else if (counter>2) break;

        }
        for (int i = number - 1; i < board.getPlayBoard().size() - 1; i += board.getColumn() - 1) {
           if (currentPlayer.getTakenTileSign().equals(board.getPlayBoard().get(i).getTakenTileSign())) counter++;
            else counter = 0;
            if (counter - 1 == tilesToWin) {
                score.increaseScore(currentPlayer);
                board.setMoveCounter(0);
                return true;
            }
       }
        return false;
    }


    public boolean checkIfDraw() {
        if (board.getMoveCounter() == board.getPlayBoard().size()) {
            board.setMoveCounter(0);
            return true;
        }
        return false;
    }

    public boolean checkIfWonVertically(Player currentPlayer, int number) {
        int counter = 0;
        for (int i = number - 1; i >= 0; i -= board.getColumn()) {
            if (currentPlayer.getTakenTileSign().equals(board.getPlayBoard().get(i).getTakenTileSign())) counter++;
            else if (counter >= 2) {
                counter += 0;
            } else counter = 0;
        }
        for (int i = number - 1; i < board.getPlayBoard().size(); i += board.getColumn()) {
            if (currentPlayer.getTakenTileSign().equals(board.getPlayBoard().get(i).getTakenTileSign())) counter++;
            else counter = 0;
            if (counter - 1 == tilesToWin) {
                score.increaseScore(currentPlayer);
                board.setMoveCounter(0);
                return true;
            }
        }
        return false;
    }

    public boolean checkIfWonMatch(Player currentPlayer) {
        if (currentPlayer.getTakenTileSign().equals(TakenTileSign.CROSS) && score.getCrossPlayerPoints() == 3) {
            System.out.println("Player" + currentPlayer + " has won the entire match ! ");
            return true;
        } else if (currentPlayer.getTakenTileSign().equals(TakenTileSign.NOUGHT) && score.getNoughtPlayerPoints() == 3) {
            System.out.println("Player" + currentPlayer + " has won the entire match ! ");
            return true;
        }
        return false;
    }

    public Score getScore() {
        return score;
    }
}
