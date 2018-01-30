package event.wastewatertank;

public class WasteWaterTankRefill {
	private String phase;

	public int getFillValue() {
		return fillValue;
	}

	private int fillValue;

	public WasteWaterTankRefill(String phase) {
		this.phase = phase;
		fillValue = 1000;
	}
	public WasteWaterTankRefill(String phase, int value) {
		this.phase = phase;
		fillValue = value;
	}

	public String getPhase() {
		return phase;
	}

	public String toString() {
		return "event - " + phase + " : WasteWaterTankRefill :" + fillValue;
	}
}
