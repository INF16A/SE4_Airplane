package event.GPS;

public class GPSSend {
    private String phase;
    private String request;

    public GPSSend(String phase, String request) {
        this.phase = phase;
        this.request = request;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : GPSSend, request: " + request;
    }
}
