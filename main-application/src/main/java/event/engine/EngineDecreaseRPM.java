package event.engine;

/**
 * Created by Lenovo on 30.01.2018.
 */
public class EngineDecreaseRPM {
    private int value;

    public EngineDecreaseRPM(int value)
    {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
