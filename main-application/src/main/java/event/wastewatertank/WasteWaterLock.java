package event.wastewatertank;

public class WasteWaterLock {
	private String phase;

	public WasteWaterLock(String phase, boolean locked) {
		this.phase = phase;
	}

	public String getPhase() {
		return phase;
	}

	public String toString() {
		return "event - " + phase + " : WasteWaterLock" ;
	}
}
