package event.sensors.airflowSensor;

public class AirflowSensorMeasure {

    private String phase;
    private String airFlow;

    public AirflowSensorMeasure(String nPhase, String nAirFlow) {
        phase = nPhase;
        airFlow = nAirFlow;
    }

    public String getAirFlow() {
        return airFlow;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "phase: " + phase + " AirflowSensorMeasure - airFlow: " + airFlow;
    }

}
