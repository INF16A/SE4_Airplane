package event.VHF;

public class VHFOn {
    private String phase;

    public VHFOn(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : VHFOn";
    }
}
