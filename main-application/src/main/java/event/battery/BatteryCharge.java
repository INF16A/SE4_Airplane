package event.battery;

public class BatteryCharge {
    private String phase;

    public int getFillValue() {
        return fillValue;
    }

    private int fillValue;

    public BatteryCharge(String phase, int value) {
        this.phase = phase;
        fillValue = value;
    }

    public BatteryCharge(String phase) {
        this.phase = phase;
        fillValue = 100;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : BatteryCharge :" + fillValue;
    }
}
