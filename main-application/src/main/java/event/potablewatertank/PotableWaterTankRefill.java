package event.potablewatertank;

public class PotableWaterTankRefill {
	private String phase;
	private int fillValue;

	public PotableWaterTankRefill(String phase) {
		this.phase = phase;
		fillValue = 1000;
	}
	public PotableWaterTankRefill(String phase, int value) {
		this.phase = phase;
		fillValue = value;
	}

	public String getPhase() {
		return phase;
	}

	public String toString() {
		return "event - " + phase + " : PotableWaterTankRefill :" + fillValue;
	}
}
