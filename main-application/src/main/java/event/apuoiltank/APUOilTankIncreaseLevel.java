package event.apuoiltank;

public class APUOilTankIncreaseLevel {
    private String phase;
    private int fillValue;

    public APUOilTankIncreaseLevel(String phase, int value) {
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
        return "event - " + phase + " : APUOilTankDecreaseLevel : " + fillValue;
    }
}
