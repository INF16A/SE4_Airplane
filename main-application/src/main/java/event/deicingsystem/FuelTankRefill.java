package main.java.event.fueltank;

public class DeIcingSystemRefill {
	private String phase;

	public int getFillValue() {
		return fillValue;
	}

	private int fillValue;

	public DeIcingSystemRefill(String phase) {
		this.phase = phase;
		fillValue = 1000;
	}
	public DeIcingSystemRefill(String phase, int value) {
		this.phase = phase;
		fillValue = value;
	}

	public String getPhase() {
		return phase;
	}

	public String toString() {
		return "event - " + phase + " : DeIcingSystemRefill :" + fillValue;
	}
}
