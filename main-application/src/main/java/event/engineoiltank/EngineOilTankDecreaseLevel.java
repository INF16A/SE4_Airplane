package main.java.event.fueltank;

public class EngineOilTankDecreaseLevel {
    private String phase;

    public int getFillValue() {
        return fillValue;
    }

    private int fillValue;

    public EngineOilTankDecreaseLevel(String phase, int value) {
        this.phase = phase;
        fillValue = value;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : EngineOilTankDecreaseLevel :" + fillValue;
    }
}
