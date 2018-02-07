package event.sensors.pitotTube;

public class PitotTubeMeasureTotalPressure {

    private String phase;

    public PitotTubeMeasureTotalPressure(String nPhase) {
        phase = nPhase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "phase: " + phase + " PitotTubeMeasureTotalPressure";
    }

}
