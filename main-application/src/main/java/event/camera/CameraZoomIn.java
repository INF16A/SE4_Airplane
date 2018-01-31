package event.Camera;

public class CameraZoomIn {
    private String phase;
    private boolean factor;

    public CameraZoomIn(String phase, boolean factor) {
        this.phase = phase;
        this.factor = factor;
    }

    public String getPhase() {
        return phase;
    }

    public boolean getFactor() {return factor; }

    public String toString() {
        return "event - " + phase + " : CameraZoomIn with " + factor;
    }
}
