package pl.pjatk.AbstractFactoryMethod;

public class FactoryProducer {
    public static MovieFactoryInterface getFactory(String choice) {
        if (choice.equalsIgnoreCase("Comedy")) {
            return new ComedyMovieFactory();
        } else if (choice.equalsIgnoreCase("Action")) {
            return new ActionMovieFactory();
        }
        return null;
    }
}
