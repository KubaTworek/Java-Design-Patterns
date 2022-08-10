package pl.pjatk.Prototype;

public class Ford extends BasicCar implements Cloneable{
    public Ford(String m) {
        modelName = m;
    }

    @Override
    public BasicCar clone() throws CloneNotSupportedException {
        Ford clone = null;
        clone = (Ford)super.clone();
        return clone;
    }
}
