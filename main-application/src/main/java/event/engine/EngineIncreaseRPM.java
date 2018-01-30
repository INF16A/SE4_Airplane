package event.engine;

/**
 * Created by Lenovo on 30.01.2018.
 */
public class EngineIncreaseRPM {
    private int value;

    public EngineIncreaseRPM(int value)
    {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
