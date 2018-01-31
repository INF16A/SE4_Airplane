package event.apu;

/**
 * Created by Lenovo on 30.01.2018.
 */
public class APUShutdown {
    private String phase;

    public APUShutdown(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : APUShutdown";
    }

}
