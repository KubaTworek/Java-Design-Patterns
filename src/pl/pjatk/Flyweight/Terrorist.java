package pl.pjatk.Flyweight;

public class Terrorist implements Player{
    private final String TASK;
    private String weapon;

    public Terrorist() {
        this.TASK = "Plant a bomb";
    }

    @Override
    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public void mission() {
        System.out.println("Terrorist with weapon " + weapon + " : Task is " + TASK);
    }
}
