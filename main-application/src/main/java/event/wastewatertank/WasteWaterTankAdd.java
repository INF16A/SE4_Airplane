package event.wastewatertank;

public class WasteWaterTankAdd {
    private String phase;
    private int fillValue;

    public WasteWaterTankAdd(String phase, int value) {
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
        return "event - " + phase + " : WasteWaterTankRefill :" + fillValue;
    }
}
