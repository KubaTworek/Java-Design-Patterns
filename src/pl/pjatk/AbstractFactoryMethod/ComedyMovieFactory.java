package pl.pjatk.AbstractFactoryMethod;

public class ComedyMovieFactory implements MovieFactoryInterface{
    @Override
    public HollyWoodMovieInterface GetHollyWoodMovie() {
        return new HollyWoodComedyMovie();
    }

    @Override
    public BollyWoodMovieInterface GetBollyWoodMovie() {
        return new BollyWoodComedyMovie();
    }
}
