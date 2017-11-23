package userInteraction;

public class SystemOutOutput implements Output {
    @Override
    public void displayMessage(String s) {
        System.out.println(s);
    }
}
