package main.java.event.tank_bottle;

public class NitrogenBottleRefill {
	private String phase;
	private int fillValue;

	public NitrogenBottleRefill(String phase) {
		this.phase = phase;
		fillValue = 250;
	}
	public NitrogenBottleRefill(String phase, int value) {
		this.phase = phase;
		fillValue = value;
	}

	public String getPhase() {
		return phase;
	}

	public String toString() {
		return "event - " + phase + " : NitrogenBottleRefill :" + fillValue;
	}
}
