package event.apu;

/**
 * Created by Lenovo on 30.01.2018.
 */
public class APUStart {
    private String phase;

    public APUStart(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }
}
