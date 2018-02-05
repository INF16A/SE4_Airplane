package event.fireextinguisher;

public class FireExtinguisherRefill {
    private String phase;
    private int fillValue;

    public FireExtinguisherRefill(String phase) {
        this.phase = phase;
        fillValue = 100;
    }

    public int getFillValue() {
        return fillValue;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : FireExtinguisherRefill :" + fillValue;
    }
}
