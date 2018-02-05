package event.deicingsystem;

public class DeIcingSystemRefill {
    private String phase;
    private int fillValue;

    public DeIcingSystemRefill(String phase) {
        this.phase = phase;
        fillValue = 1000;
    }

    public DeIcingSystemRefill(String phase, int value) {
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
        return "event - " + phase + " : DeIcingSystemRefill :" + fillValue;
    }
}
