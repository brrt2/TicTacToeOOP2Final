package gameManagement.moveManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class MoveHistory implements gameManagement.Observer{

    private static List<Move> moveArchive = new ArrayList<>();

    public static void addToArchive(Move move) {
        moveArchive.add(move);
    }

    public static List<Move> getMoveArchive() {
        return moveArchive;
    }

    @Override
    public void update(Move move) {
        addToArchive(move);
    }
}
