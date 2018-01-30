package event.sensors.turbulentAirFlowSensor;

public class TurbulentAirFlowSensorMeasure {

    private String phase;
    private int airFlow;

    public TurbulentAirFlowSensorMeasure(String nPhase, int nAirFlow) {
        airFlow = nAirFlow;
        phase = nPhase;
    }

    public int getAirFlow() {
        return airFlow;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "phase: " + phase + " TurbulentAirFlowSensorMeasure";
    }

}
