package event.wastewatertank;

public class WasteWaterTankPumpOut {
    private String phase;

    public WasteWaterTankPumpOut(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : WasteWaterTankTakeOut :";
    }
}
