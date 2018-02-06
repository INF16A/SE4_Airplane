package event.satcom;

public class SatComConnect {
    private String phase;
    private String satellite;
    private String frequency;

    public SatComConnect(String phase, String satellite, String frequency) {
        this.phase = phase;
        this.satellite = satellite;
        this.frequency = frequency;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : SatComConnect with " + satellite + " on " + frequency;
    }
}
