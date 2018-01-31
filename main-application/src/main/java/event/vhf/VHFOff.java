package event.vhf;

public class VHFOff {
    private String phase;

    public VHFOff(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : VHFOff";
    }
}
