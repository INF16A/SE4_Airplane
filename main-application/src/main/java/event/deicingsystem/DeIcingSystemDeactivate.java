package main.java.event.fueltank;

public class DeIcingSystemDeactivate {
    private String phase;

    public int getFillValue() {
        return fillValue;
    }

    private boolean active;

    public DeIcingSystemDeactivate(String phase) {
        this.phase = phase;
        active = false;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : DeIcingSystemDeactivate :" + active;
    }
}
