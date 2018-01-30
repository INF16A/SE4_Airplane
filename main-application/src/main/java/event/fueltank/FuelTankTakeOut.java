package main.java.event.tank_bottle;

public class FuelTankTakeOut {
	private String phase;

	public int getFillValue() {
		return fillValue;
	}

	private int fillValue;

	/*public FuelTankTakeOut(String phase) {
		this.phase = phase;
		fillValue = 1000;
	}*/
	public FuelTankTakeOut(String phase, int value) {
		this.phase = phase;
		fillValue = value;
	}

	public String getPhase() {
		return phase;
	}

	public String toString() {
		return "event - " + phase + " : FuelTankTakeOut : " + fillValue;
	}
}
