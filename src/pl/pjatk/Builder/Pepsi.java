package pl.pjatk.Builder;

public class Pepsi extends ColdDrink{
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 1.5f;
    }
}
