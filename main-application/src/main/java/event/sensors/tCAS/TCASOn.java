package event.sensors.tCAS;

public class TCASOn {

    private String phase;

    public TCASOn(String nPhase) {
        phase = nPhase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "phase: " + phase + " TCASOn";
    }

}
