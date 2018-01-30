package event.sensors.tCAS;

public class TCASSetAltitude {

    private String phase;
    private int value;

    public TCASSetAltitude(String nPhase, int nValue) {
        phase = nPhase;
        value = nValue;
    }

    public int getValue() {
        return value;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "phase: " + phase + " TCASSetAltitude";
    }

}
