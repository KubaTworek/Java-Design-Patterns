package pl.pjatk.Builder;

public class Director {
    MealBuilderInterface myBuilder;

    public void construct(MealBuilderInterface builder){
        myBuilder = builder;
        myBuilder.buildBurger();
        myBuilder.buildDrink();
    }
}
