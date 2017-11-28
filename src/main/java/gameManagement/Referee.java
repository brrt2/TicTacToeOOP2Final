package gameManagement;
import gameManagement.boardTools.TilesToWin;
import gameManagement.tiles.TakenTileSign;
import gameManagement.tiles.Tile;
import gameManagement.validation.Score;
import players.Player;
import java.util.ArrayList;
import java.util.List;

public class Referee{

    private Board board;
    private TilesToWin tilesToWin;
    private Score score;


    public Referee(Board board,TilesToWin tilesToWin,Score score) {
        this.board = board;
        this.tilesToWin = tilesToWin;
        this.score=score;
    }

    boolean checkIfWonHorizontally(Player currentPlayer) {
        int counter = 0;
        for (int i = 0; i < board.getPlayBoard().size(); i++) {
            if (currentPlayer.getTakenTileSign().equals(board.getPlayBoard().get(i).getTakenTileSign())) counter++;
            else counter = 0;
            if (counter == tilesToWin.getValue()) {
                score.increaseScore(currentPlayer);
                board.setMoveCounter(0);
                return true;
            }
        }
        return false;
    }

    boolean checkDiagonalLeftToRight(Player currentPlayer, int index) {
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

        return iterate(tilesOnDiagonal,currentPlayer);
    }

    boolean checkDiagonalRL(Player currentPlayer, int index) {
        ArrayList<Tile> tiles = new ArrayList<>();
        while (index - board.getColumn() > 0) {
            index = index - board.getColumn() + 1;
            if (index % board.getColumn() == 0) {
                break;
            }
        }
        while (index < board.getPlayBoard().size()) {
            tiles.add(board.getPlayBoard().get(index - 1));
            if (index % board.getColumn() == 1) {
                break;
            }
            index += (board.getColumn() - 1);
        }
        return iterate(tiles,currentPlayer);

    }

    private boolean iterate(List<Tile> tiles,Player currentPlayer){
        int counter =0;
        for (int i = 0; i < tiles.size(); i++) {
            if (currentPlayer.getTakenTileSign().equals(tiles.get(i).getTakenTileSign())) counter++;
            if (counter == tilesToWin.getValue()) {
                score.increaseScore(currentPlayer);
                board.setMoveCounter(0);
                return true;
            }
        }
        return false;

    }

    boolean checkIfDraw() {
        if (board.getMoveCounter() == board.getPlayBoard().size()) {
            board.setMoveCounter(0);
            score.increaseScoreDraw();
            return true;
        }
        return false;
    }

    boolean checkIfWonVertically(Player currentPlayer, int number) {
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
            if (counter - 1 == tilesToWin.getValue()) {
                score.increaseScore(currentPlayer);
                board.setMoveCounter(0);
                return true;
            }
        }
        return false;
    }

    boolean checkIfWonMatch(Player currentPlayer) {

        if (score.getRoundNumber() == score.getNumberOfMatches().getValue()) {
            if (currentPlayer.getTakenTileSign().equals(TakenTileSign.CROSS) && score.getCrossPlayerPoints() > score.getNoughtPlayerPoints()) {
                System.out.println("Player" + currentPlayer + " has won the entire match ! ");
                return true;
            } else if (currentPlayer.getTakenTileSign().equals(TakenTileSign.NOUGHT) && score.getCrossPlayerPoints() < score.getNoughtPlayerPoints()) {
                System.out.println("Player" + currentPlayer + " has won the entire match ! ");
                return true;
            } else if (score.getNoughtPlayerPoints() == score.getCrossPlayerPoints()) {
                System.out.println("The match ended in a draw !");
                return true;
            }
        }
        return false;
    }

    Score getScore() {
        return score;
    }

    public Board getBoard() {
        return board;
    }

}
