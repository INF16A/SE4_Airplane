package main.java.event.tank_bottle;

public class OxygenBottleTakeOut {
	private String phase;
	private int fillValue;

	/*public OxygenBottleTakeOut(String phase) {
		this.phase = phase;
		fillValue = 100;
	}*/
	public OxygenBottleTakeOut(String phase, int value) {
		this.phase = phase;
		fillValue = value;
	}

	public String getPhase() {
		return phase;
	}

	public String toString() {
		return "event - " + phase + " : OxygenBottleTakeOut :" + fillValue;
	}
}