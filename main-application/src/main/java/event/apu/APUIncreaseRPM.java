package event.apu;

/**
 * Created by Lenovo on 30.01.2018.
 */
public class APUIncreaseRPM {
    private String phase;
    private int value;

    public APUIncreaseRPM(String phase, int value) {
        this.phase = phase;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : APUIncreaseRPM";
    }
}
