package event.engine;

/**
 * Created by Lenovo on 30.01.2018.
 */
public class EngineDecreaseRPM {
    private String phase;
    private int value;

    public EngineDecreaseRPM(String phase, int value)
    {
        this.phase = phase;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getPhase() {
        return phase;
    }
}
