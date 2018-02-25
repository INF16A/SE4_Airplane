package event.radar;

public class RadarOff {
    private String phase;

    public RadarOff(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : RadarOff";
    }
}
