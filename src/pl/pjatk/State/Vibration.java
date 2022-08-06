package pl.pjatk.State;

public class Vibration implements MobileAlertState {
    @Override
    public void alert() {
        System.out.println("vibration...");
    }
}
