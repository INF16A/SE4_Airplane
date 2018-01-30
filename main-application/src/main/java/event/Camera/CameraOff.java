package event.Camera;

public class CameraOff {
    private String phase;

    public CameraOff(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : CameraOff";
    }
}
