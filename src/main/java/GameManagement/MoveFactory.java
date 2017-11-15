package GameManagement;

public class MoveFactory {

    public static Move createMove(int row,int column){
        return new Move(row,column);
    }

}
