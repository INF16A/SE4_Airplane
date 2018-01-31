package event.camera;

public class CameraOn {
    private String phase;

    public CameraOn(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : CameraOn";
    }
}
