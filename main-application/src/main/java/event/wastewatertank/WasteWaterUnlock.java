package event.wastewatertank;

public class WasteWaterUnlock {
    private String phase;

    public WasteWaterUnlock(String phase, boolean locked) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : WasteWaterUnlock";
    }
}
