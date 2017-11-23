package userInteraction;

public class SystemErrOutput implements Output {
    @Override
    public void displayMessage(String s) {
        System.err.println(s);
    }
}
