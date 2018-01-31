package main.java.event.fueltank;

public class FireExtinguisherRefill {
    private String phase;

    public int getFillValue() {
        return fillValue;
    }

    private int fillValue;

    public FireExtinguisherRefill(String phase) {
        this.phase = phase;
        fillValue = 100;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : FireExtinguisherRefill :" + fillValue;
    }
}
