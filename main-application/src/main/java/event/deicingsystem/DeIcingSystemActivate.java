package main.java.event.fueltank;

public class DeIcingSystemActivate {
    private String phase;

    public int getFillValue() {
        return fillValue;
    }

    private boolean active;

    public DeIcingSystemActivate(String phase) {
        this.phase = phase;
        active = true;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : DeIcingSystemActivate :" + active;
    }
}
