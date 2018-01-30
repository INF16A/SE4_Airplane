package event.gear;

/**
 * Created by Lenovo on 30.01.2018.
 */
public class GearSetBrake {

    private int percent;

    public GearSetBrake() {
    }

    public GearSetBrake(int percent) {
        this.percent = percent;
    }

    public int getPercent() {
        return percent;
    }
}
