package event.fuelSensor;

public class FuelSensorMeasure {
    private String phase;
    private double fuelAmount;

    public FuelSensorMeasure(String phase, double fuelAmount) {
        this.phase = phase;
        this.fuelAmount = fuelAmount;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : FuelSensorMeasure Amount:" + fuelAmount;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }
}