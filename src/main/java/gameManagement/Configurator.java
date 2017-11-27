package gameManagement;

import gameManagement.boardTools.*;
import gameManagement.locale.Language;
import gameManagement.tiles.TakenTileSign;
import gameManagement.tiles.Tile;
import players.Player;
import userInteraction.Output;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Configurator {

    public void configureGame (String str, String name, String name2, Height height, Width width, TilesToWin tilesTowin, Output output,
                               Language language, NumberOfMatches numberOfMatches,PointsForWin pointsForWin,String selectedStructure){

        Player first = new Player(name, TakenTileSign.NOUGHT);
        Player second = new Player(name2, TakenTileSign.CROSS);

        List<Tile> list=null;
        if(selectedStructure.equals(("a"))) list = new ArrayList<>();
        else if (selectedStructure.equals(("l"))) list = new LinkedList<>();

        Board board = new Board.Builder()
                .height(height)
                .column(width)
                .playBoard(list)
                .build();

        Turn turn = new Turn(first,second);

        Game game = new Game(turn,board, tilesTowin,output,language,numberOfMatches,pointsForWin);

        if(str.equals("x")) game.getTurn().setCurrentPlayer(second);
        else if(str.equals("o")) game.getTurn().setCurrentPlayer(first);

        do {
            game.play();

        } while (game.getGameState()!= GameState.WIN&&game.getGameState()!= GameState.DRAW);
    }

}
