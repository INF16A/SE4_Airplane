package event.radar;

public class RadarScan {
    private String phase;
    private String environment;

    public RadarScan(String phase, String environment) {
        this.phase = phase;
        this.environment = environment;
    }
    public String getEnvironment() {
        return environment;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : RadarScan, environment: " + environment;
    }
}
