package gameManagement;

import gameManagement.boardTools.Height;
import gameManagement.boardTools.TilesToWin;
import gameManagement.boardTools.Width;
import gameManagement.locale.Language;
import gameManagement.tiles.TakenTileSign;
import players.Player;
import userInteraction.Output;

public class Configurator {

    public void configureGame (String str, String name, String name2, Height height, Width width, TilesToWin tilesTowin, Output output, Language language){
        Player first = new Player(name, TakenTileSign.NOUGHT);
        Player second = new Player(name2, TakenTileSign.CROSS);
        Board board = new Board(height, width);
        Turn turn = new Turn(first,second);
        Game game = new Game(turn,board, tilesTowin,output,language);
        if(str.equals("x")) game.getTurn().setCurrentPlayer(second);
        else if(str.equals("o")) game.getTurn().setCurrentPlayer(first);
        do {
            game.play();

        } while (game.getGameState()!= GameState.WIN&&game.getGameState()!= GameState.DRAW);
    }


}
