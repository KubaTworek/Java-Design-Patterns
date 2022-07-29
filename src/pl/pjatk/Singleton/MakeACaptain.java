package pl.pjatk.Singleton;

public class MakeACaptain {
    private MakeACaptain() {
    }
    public static MakeACaptain getCaptain(){
        return SingletonHelper._captain;
    }

    private static class SingletonHelper {
        private static final MakeACaptain _captain = new MakeACaptain();
    }
}
