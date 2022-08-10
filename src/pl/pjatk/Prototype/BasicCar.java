package pl.pjatk.Prototype;

import java.util.Random;

public class BasicCar implements Cloneable{
    public String modelName;
    public int price;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public static int setPrice() {
        int price = 0;
        Random r = new Random();
        int p = r.nextInt(100000);
        price = p;
        return price;
    }

    public BasicCar clone() throws CloneNotSupportedException {
        BasicCar clone = null;
        clone = (BasicCar)super.clone();
        return clone;
    }
}
