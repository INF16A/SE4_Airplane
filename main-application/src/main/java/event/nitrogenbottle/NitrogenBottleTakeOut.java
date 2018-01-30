package event.nitrogenbottle;

public class NitrogenBottleTakeOut {
	private String phase;
	private int fillValue;

	/*public NitrogenBottleTakeOut(String phase) {
		this.phase = phase;
		fillValue = 250;
	}*/
	public NitrogenBottleTakeOut(String phase, int value) {
		this.phase = phase;
		fillValue = value;
	}

	public String getPhase() {
		return phase;
	}

	public String toString() {
		return "event - " + phase + " : NitrogenBottleTakeOut :" + fillValue;
	}
}
