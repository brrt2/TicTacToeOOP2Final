package gamemanagement;

import gamemanagement.configuration.*;
import gamemanagement.locale.Language;
import gamemanagement.tiles.TakenTileSign;
import gamemanagement.tiles.Tile;
import gamemanagement.validation.Score;
import players.Player;
import userInteraction.Output;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Configurator {

    public void configureGame (String str, String name, String name2, Height height, Width width, TilesToWin tilesTowin, Output output,
                               Language language, NumberOfRounds numberOfRounds, PointsForWin pointsForWin, String selectedStructure, Scanner scan){

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
        Score score = new Score(numberOfRounds,pointsForWin);
        Referee referee = new Referee(board,tilesTowin,score);
        Game game = new Game(turn,output,language,referee,scan);

        if(str.equals("x")) game.getTurn().setCurrentPlayer(second);
        else if(str.equals("o")) game.getTurn().setCurrentPlayer(first);

        do {
            game.play();

        } while (game.getGameState()!= GameState.WIN&&game.getGameState()!= GameState.DRAW);
    }

}
