package main.java.event.tank_bottle;

public class EngineOilTankIncreaseLevel {
    private String phase;

    public int getFillValue() {
        return fillValue;
    }

    private int fillValue;

    public EngineOilTankIncreaseLevel(String phase, int value) {
        this.phase = phase;
        fillValue = value;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : EngineOilTankIncreaseLevel : " + fillValue;
    }
}
