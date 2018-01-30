package event.VHF;

public class VHFBackwardChannel {
    private String phase;

    public VHFBackwardChannel(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : VHFBackwardChannel";
    }
}
