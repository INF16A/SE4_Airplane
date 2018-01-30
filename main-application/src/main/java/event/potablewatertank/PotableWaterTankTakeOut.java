package event.potablewatertank;

public class PotableWaterTankTakeOut {
	private String phase;
	private int fillValue;

	/*public PotableWaterTankTakeOut(String phase) {
		this.phase = phase;
		fillValue = 100;
	}*/
	public PotableWaterTankTakeOut(String phase, int value) {
		this.phase = phase;
		fillValue = value;
	}

	public String getPhase() {
		return phase;
	}

	public String toString() {
		return "event - " + phase + " : PotableWaterTankTakeOut :" + fillValue;
	}
}
