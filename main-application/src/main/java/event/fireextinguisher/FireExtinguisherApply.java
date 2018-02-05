package event.fireextinguisher;

public class FireExtinguisherApply {
    private String phase;

    public int getFillValue() {
        return fillValue;
    }

    private int fillValue;

    public FireExtinguisherApply(String phase) {
        this.phase = phase;
        fillValue = 0;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : FireExtinguisherApply :" + fillValue;
    }
}
