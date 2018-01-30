package event.hydraulicPump;

/**
 * Created by Lenovo on 30.01.2018.
 */
public class HydraulicPumpDecompress {
    private String phase;
    public HydraulicPumpDecompress(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : HydraulicPumpDecompress";
    }
}
