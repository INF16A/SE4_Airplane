package event.VHF;

public class VHFSelectChannel {
    private String phase;
    private String channel;

    public VHFSelectChannel(String phase, String channel) {
        this.phase = phase;
        this.channel = channel;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : VHFSelectChannel - Selected Channel: " + channel;
    }
}
