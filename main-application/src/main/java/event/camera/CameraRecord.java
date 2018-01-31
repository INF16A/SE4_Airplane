package event.Camera;

public class CameraRecord {
    private String phase;

    public CameraRecord(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : CameraRecord";
    }
}
