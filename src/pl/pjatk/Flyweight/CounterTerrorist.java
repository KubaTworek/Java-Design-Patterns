package pl.pjatk.Flyweight;

public class CounterTerrorist implements Player{
    private final String TASK;
    private String weapon;

    public CounterTerrorist() {
        this.TASK = "Defuse a bomb";
    }

    @Override
    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public void mission() {
        System.out.println("Counter-Terrorist with weapon " + weapon + " : Task is " + TASK);
    }
}
