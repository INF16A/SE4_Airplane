package event.satcom;

public class SatComReceive {
    private String phase;

    public SatComReceive(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : SatComReceive";
    }
}
