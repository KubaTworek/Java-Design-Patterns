package pl.pjatk.FactoryMethod;

public class Duck implements AnimalInterface {
    @Override
    public void speak() {
        System.out.println("Duck says Pack-pack");
    }
}
