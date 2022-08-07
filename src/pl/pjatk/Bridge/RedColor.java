package pl.pjatk.Bridge;

public class RedColor implements ColorInterface{
    @Override
    public void fillWthColor(int border) {
        System.out.println("Red color with " + border + " inch border");
    }
}
