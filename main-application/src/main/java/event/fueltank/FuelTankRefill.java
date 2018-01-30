package main.java.event.fueltank;

public class FuelTankRefill {
	private String phase;

	public int getFillValue() {
		return fillValue;
	}

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
