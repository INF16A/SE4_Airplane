package event.satcom;

public class SatComOff {
    private String phase;

    public SatComOff(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : SatComOff";
    }
}
