package event.fuelFlowSensor;

public class FuelFlowSensorMeasure {
    private String phase;
    private double  fuelFlowAmount;

    public FuelFlowSensorMeasure(String phase, double fuelFlowAmount) {
        this.phase = phase;
        this.fuelFlowAmount = fuelFlowAmount;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : FuelFlowSensorMeasure Amount:" + fuelFlowAmount;
    }

    public double getFuelFlowAmount() {
        return fuelFlowAmount;
    }
}
