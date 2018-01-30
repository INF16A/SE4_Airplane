package event.oxygenbottle;

public class OxygenBottleRefill {
	private String phase;

	public int getFillValue() {
		return fillValue;
	}

	private int fillValue;

	public OxygenBottleRefill(String phase) {
		this.phase = phase;
		fillValue = 100;
	}
	public OxygenBottleRefill(String phase, int value) {
		this.phase = phase;
		fillValue = value;
	}

	public String getPhase() {
		return phase;
	}

	public String toString() {
		return "event - " + phase + " : OxygenBottleRefill :" + fillValue;
	}
}
