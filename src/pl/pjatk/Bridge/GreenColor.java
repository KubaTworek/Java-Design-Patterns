package pl.pjatk.Bridge;

public class GreenColor implements ColorInterface{
    @Override
    public void fillWthColor(int border) {
        System.out.println("Green color with " + border + " inch border");
    }
}
