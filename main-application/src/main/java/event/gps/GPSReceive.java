package event.gps;

public class GPSReceive {
    private String phase;

    public GPSReceive(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : GPSReceive";
    }
}
