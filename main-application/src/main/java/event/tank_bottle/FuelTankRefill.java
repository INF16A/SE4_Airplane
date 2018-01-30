package main.java.event.tank_bottle;

public class FuelTankRefill {
	private String phase;

	public FuelTankRefill(String phase) {
		this.phase = phase;
	}

	public String getPhase() {
		return phase;
	}

	public String toString() {
		return "event - " + phase + " : FuelTankRefill";
	}
}
