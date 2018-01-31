package event.satcom;

public class SatComSend {
    private String phase;
    private String request;

    public SatComSend(String phase, String request) {
        this.phase = phase;
        this.request = request;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : SatComSend with message: " + request;
    }
}
