package event.sensors.tCAS;

public class TCASScann {

    private String phase;
    private String environment;

    public TCASScann(String nPhase, String nEnvironment) {
        phase = nPhase;
        environment = nEnvironment;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "phase: " + phase + " TCASScann";
    }

}
