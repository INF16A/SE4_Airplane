package event.sensors.turbulentAirFlowSensor;

public class TurbulentAirFlowSensorAlarm {

    private String phase;

    public TurbulentAirFlowSensorAlarm(String nPhase) {
        phase = nPhase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "phase: " + phase + " TurbulentAirFlowSensorAlarm";
    }

}
