package pl.pjatk.Bridge;

public class RectangleBridge extends ShapeBridge {
    public RectangleBridge(ColorInterface c) {
        super(c);
    }

    @Override
    public void drawShape(int border) {
        System.out.println("This Rectangle is colored with ");
        color.fillWthColor(border);
    }

    @Override
    public void modifyBorder(int border, int increment) {
        System.out.println("\nNow we are changing the border length " + increment + " times");
        border = border * increment;
        drawShape(border);
    }
}
