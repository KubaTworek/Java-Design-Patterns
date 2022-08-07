package pl.pjatk.Bridge;

public abstract class ShapeBridge {
    public ColorInterface color;

    public ShapeBridge(ColorInterface c){
        this.color = c;
    }

    public abstract void drawShape(int border);
    public abstract void modifyBorder(int border, int increment);
}
