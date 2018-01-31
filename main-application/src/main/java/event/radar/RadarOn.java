package event.radar;

public class RadarOn {
    private String phase;

    public RadarOn(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : RadarOn";
    }
}

