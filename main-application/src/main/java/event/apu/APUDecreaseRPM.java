package event.apu;

/**
 * Created by Lenovo on 30.01.2018.
 */
public class APUDecreaseRPM {

    private int rpm;

    public APUDecreaseRPM(int rpm) {
        this.rpm = rpm;
    }


    public int getRpm() {
        return rpm;
    }
}
