package event.deicingsystem;

public class DeIcingSystemDeIce {
    private String phase;

    public int getFillValue() {
        return fillValue;
    }

    private int fillValue;

    public DeIcingSystemDeIce(String phase, int value) {
        this.phase = phase;
        fillValue = value;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : DeIcingSystemDeIce : " + fillValue;
    }
}
