package event.potablewatertank;

public class PotableWaterTankLock {
    private String phase;

    public PotableWaterTankLock(String phase, boolean locked) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : PotableWaterTankLock";
    }
}
