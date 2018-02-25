package event.iceDetectorProbe;

public class IceDetectorProbeMeasure {
    private String phase;
    private String iceAmount;

    public IceDetectorProbeMeasure(String phase, String iceAmount) {
        this.phase = phase;
        this.iceAmount = iceAmount;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : IceDetectorProbeMeasure Amount:'" + iceAmount+"'";
    }

    public String getIceAmount() {
        return iceAmount;
    }
}
