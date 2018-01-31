package event.wastewatertank;

public class WasteWaterTankAdd {
	private String phase;

	public int getFillValue() {
		return fillValue;
	}

	private int fillValue;

	public WasteWaterTankAdd(String phase, int value) {
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
