package event.wastewatertank;

public class WasteWaterTankTakeOut {
	private String phase;
	private int fillValue;

	/*public WasteWaterTankTakeOut(String phase) {
		this.phase = phase;
		fillValue = 100;
	}*/
	public WasteWaterTankTakeOut(String phase, int value) {
		this.phase = phase;
		fillValue = value;
	}

	public String getPhase() {
		return phase;
	}

	public String toString() {
		return "event - " + phase + " : WasteWaterTankTakeOut :" + fillValue;
	}
}
