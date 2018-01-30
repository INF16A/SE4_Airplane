package event.sensors.turbulentAirFlowSensor;

public class TurbulentAirFlowSensorMeasure {

    private String phase;
    private String airFlow;

    public TurbulentAirFlowSensorMeasure(String nPhase, String nAirFlow) {
        airFlow = nAirFlow;
        phase = nPhase;
    }

    public String getAirFlow() {
        return airFlow;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "phase: " + phase + " TurbulentAirFlowSensorMeasure";
    }

}
