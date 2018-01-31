package event.sensors.airflowSensor;

public class AirflowSensorAlarm {

    private String phase;
    private int threshhold;

    public AirflowSensorAlarm(String nPhase, int nThreshhold) {
        phase = nPhase;
        threshhold = nThreshhold;
    }

    public int getThreshhold() {
        return threshhold;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "phase: " + phase + " AirflowSensorAlarm - threshhold: " + threshhold;
    }

}
