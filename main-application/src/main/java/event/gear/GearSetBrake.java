package event.gear;

/**
 * Created by Lenovo on 30.01.2018.
 */
public class GearSetBrake {
    private String phase;
    private int percent;

    public GearSetBrake() {
    }

    public GearSetBrake(String phase, int percent) {
        this.phase = phase;
        this.percent = percent;
    }

    public int getPercent() {
        return percent;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : GearSetBrake";
    }

}
