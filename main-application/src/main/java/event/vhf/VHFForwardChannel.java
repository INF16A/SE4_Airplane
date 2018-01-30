package event.VHF;

public class VHFForwardChannel {
    private String phase;

    public VHFForwardChannel(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : VHFForwardChannel";
    }
}
