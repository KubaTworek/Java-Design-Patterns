package pl.pjatk.Prototype;

public class Nano extends BasicCar implements Cloneable{
    public Nano(String m) {
        modelName = m;
    }

    @Override
    public BasicCar clone() throws CloneNotSupportedException {
        Nano clone = null;
        clone = (Nano)super.clone();
        return clone;
    }
}
