package event.engineoiltank;

public class EngineOilTankIncreaseLevel {
    private String phase;
    private int fillValue;

    public EngineOilTankIncreaseLevel(String phase, int value) {
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
        return "event - " + phase + " : EngineOilTankIncreaseLevel : " + fillValue;
    }
}
