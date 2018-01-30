package event.gear;

/**
 * Created by Lenovo on 30.01.2018.
 */
public class GearReleaseBrake {
    private String phase;
    public GearReleaseBrake(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : GearReleaseBrake";
    }
}
