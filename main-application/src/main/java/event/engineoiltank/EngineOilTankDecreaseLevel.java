package event.engineoiltank;

public class EngineOilTankDecreaseLevel {
    private String phase;
    private int fillValue;

    public EngineOilTankDecreaseLevel(String phase, int value) {
        this.phase = phase;
        fillValue = value;
    }

    public int getFillValue() {
        return fillValue;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : EngineOilTankDecreaseLevel :" + fillValue;
    }
}
