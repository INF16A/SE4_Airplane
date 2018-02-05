package event.oxygenbottle;

public class OxygenBottleTakeOut {
    private String phase;
    private int fillValue;

    public OxygenBottleTakeOut(String phase, int value) {
        this.phase = phase;
        fillValue = value;
    }

    public int getFillValue() {
        return fillValue;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : OxygenBottleTakeOut :" + fillValue;
    }
}
