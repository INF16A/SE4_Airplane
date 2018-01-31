package event.Camera;

public class CameraSetType {
    private String phase;
    private String type;
    public CameraSetType(String phase, String type) {
        this.phase = phase;
        this.type = type;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : CameraSetType to " + type;
    }
}
