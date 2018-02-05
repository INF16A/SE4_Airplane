package event.deicingsystem;

public class DeIcingSystemDeactivate {
    private String phase;
    private boolean active;

    public DeIcingSystemDeactivate(String phase) {
        this.phase = phase;
        active = false;
    }

    public boolean getActive() {
        return active;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : DeIcingSystemDeactivate :" + active;
    }
}
