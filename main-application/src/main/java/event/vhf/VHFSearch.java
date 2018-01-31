package event.VHF;

public class VHFSearch {
    private String phase;

    public VHFSearch(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : VHFSearch";
    }
}
