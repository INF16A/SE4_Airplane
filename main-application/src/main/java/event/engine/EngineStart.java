package event.engine;

/**
 * Created by Lenovo on 30.01.2018.
 */
public class EngineStart {
    private String phase;
    public EngineStart(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : EngineStart";
    }
}
