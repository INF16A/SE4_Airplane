package event.sensors.pitotTube;

public class PitotTubeMeasureVelocity {

    private String phase;

    public PitotTubeMeasureVelocity(String nPhase) {
        phase = nPhase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "phase: " + phase + " PitotTubeMeasureVelocity";
    }

}
