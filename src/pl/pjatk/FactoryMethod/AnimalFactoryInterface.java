package pl.pjatk.FactoryMethod;

public abstract class AnimalFactoryInterface {
    public abstract AnimalInterface GetAnimalType(String type) throws Exception;
}
