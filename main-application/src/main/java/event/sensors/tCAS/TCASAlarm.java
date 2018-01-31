package event.sensors.tCAS;

public class TCASAlarm {

    private String phase;

    public TCASAlarm(String nPhase) {
        phase = nPhase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "phase: " + phase + " TCASAlarm";
    }

}
