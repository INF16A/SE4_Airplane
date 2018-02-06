package event.potablewatertank;

public class PotableWaterTankUnlock {
    private String phase;

    public PotableWaterTankUnlock(String phase, boolean locked) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : PotableWaterTankUnlock";
    }
}
