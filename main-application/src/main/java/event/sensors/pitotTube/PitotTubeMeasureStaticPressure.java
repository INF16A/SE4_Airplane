package event.sensors.pitotTube;

public class PitotTubeMeasureStaticPressure {

    private String phase;

    public PitotTubeMeasureStaticPressure(String nPhase) {
        phase = nPhase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "phase: " + phase + " PitotTubeMeasureStaticPressure";
    }

}
