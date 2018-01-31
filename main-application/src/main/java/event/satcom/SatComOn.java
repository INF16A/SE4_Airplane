package event.satcom;

public class SatComOn {
    private String phase;

    public SatComOn(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : SatComOn";
    }
}
