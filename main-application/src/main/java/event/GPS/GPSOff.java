package event.GPS;

public class GPSOff {
    private String phase;

    public GPSOff(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : GPSOff";
    }
}
