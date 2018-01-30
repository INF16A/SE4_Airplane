package event.deicingsystem;

public class DeIcingSystemDeactivate {
    private String phase;

    public boolean getActive() {
        return active;
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
