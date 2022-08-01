package pl.pjatk.AbstractFactoryMethod;

public class ActionMovieFactory implements MovieFactoryInterface{
    @Override
    public HollyWoodMovieInterface GetHollyWoodMovie() {
        return new HollyWoodActionMovie();
    }

    @Override
    public BollyWoodMovieInterface GetBollyWoodMovie() {
        return new BollyWoodActionMovie();
    }
}
