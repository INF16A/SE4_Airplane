package main.java.event.tank_bottle;

public class FuelTankRefill {
	private String phase;
	private int fillValue;

	public FuelTankRefill(String phase) {
		this.phase = phase;
		fillValue = 1000;
	}
	public FuelTankRefill(String phase, int value) {
		this.phase = phase;
		fillValue = value;
	}

	public String getPhase() {
		return phase;
	}

	public String toString() {
		return "event - " + phase + " : FuelTankRefill :" + fillValue;
	}
}