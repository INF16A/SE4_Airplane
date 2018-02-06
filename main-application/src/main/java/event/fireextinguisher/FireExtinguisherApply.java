package event.fireextinguisher;

public class FireExtinguisherApply {
    private String phase;
    private int fillValue;

    public FireExtinguisherApply(String phase) {
        this.phase = phase;
        fillValue = 0;
    }

    public int getFillValue() {
        return fillValue;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : FireExtinguisherApply :" + fillValue;
    }
}
