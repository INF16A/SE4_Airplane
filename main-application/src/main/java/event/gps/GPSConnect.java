package event.gps;

public class GPSConnect {
    private String phase;
    private String satellite;

    public GPSConnect(String phase, String satellite) {
        this.phase = phase;
        this.satellite = satellite;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : GPSConnect with " + satellite;
    }
}
