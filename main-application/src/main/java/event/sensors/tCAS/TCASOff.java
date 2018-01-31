package event.sensors.tCAS;

public class TCASOff {

    private String phase;

    public TCASOff(String nPhase) {
        phase = nPhase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "phase: " + phase + " TCASOff";
    }
}
