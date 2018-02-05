package event.battery;

public class BatteryDischarge {
    private String phase;

    public int getFillValue() {
        return fillValue;
    }

    private int fillValue;

    public BatteryDischarge(String phase) {
        this.phase = phase;
        fillValue = 0;
    }

    public BatteryDischarge(String phase, int value) {
        this.phase = phase;
        fillValue = value;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : BatteryCharge :" + fillValue;
    }
}
