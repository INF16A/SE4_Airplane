package event.apu;

/**
 * Created by Lenovo on 30.01.2018.
 */
public class APUIncreaseRPM {
    private int value;

    public APUIncreaseRPM(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
