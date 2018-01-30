package event.engine;

/**
 * Created by Lenovo on 30.01.2018.
 */
public class EngineShutdown {
    private String phase;
    public EngineShutdown(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }
}
