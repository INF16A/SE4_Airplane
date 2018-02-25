package event.exhaustGasTemperatureSensor;

public class ExhaustGasTemperatureSensorMeasurement {
    private String phase;
    private int temperature;

    public ExhaustGasTemperatureSensorMeasurement(String phase, int temperature) {
        this.phase = phase;
        this.temperature = temperature;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : ExhaustGasTemperatureSensorMeasurement Temperature:" + temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}
