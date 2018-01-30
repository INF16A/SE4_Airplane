package event.apu;

/**
 * Created by Lenovo on 30.01.2018.
 */
public class APUDecreaseRPM {
    private String phase;
    private int rpm;

    public APUDecreaseRPM(String phase, int rpm) {
        this.phase = phase;
        this.rpm = rpm;
    }


    public int getRpm() {
        return rpm;
    }

    public String getPhase() {
        return phase;
    }
}
