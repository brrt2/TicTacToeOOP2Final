package userInteraction;

public class SystemErrOutput implements Output {
    @Override
    public void displayMessage(String s) {
        System.err.println(s);
    }

    @Override
    public void displayBoard(Object o) {
        System.err.println(o);
    }

}
