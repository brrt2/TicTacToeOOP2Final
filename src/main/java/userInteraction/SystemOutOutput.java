package userInteraction;

public class SystemOutOutput implements Output {
    @Override
    public void displayMessage(String s) {
        System.out.println(s);
    }

    @Override
    public void displayBoard(Object o) {
        System.out.println(o);
    }
}
