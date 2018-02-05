package event.deicingsystem;

public class DeIcingSystemActivate {
    private String phase;
    private boolean active;

    public DeIcingSystemActivate(String phase) {
        this.phase = phase;
        active = true;
    }

    public boolean getActive() {
        return active;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : DeIcingSystemActivate :" + active;
    }
}
