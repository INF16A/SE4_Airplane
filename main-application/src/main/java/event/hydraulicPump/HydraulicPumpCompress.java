package event.hydraulicPump;

/**
 * Created by Lenovo on 30.01.2018.
 */
public class HydraulicPumpCompress {
    private String phase;
    private int amount;
    public HydraulicPumpCompress(String phase) {
        this.phase = phase;
    }
    public HydraulicPumpCompress(String phase, int amount) {
        this.phase = phase;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "event - " + phase + " : HydraulicPumpCompress";
    }
}
