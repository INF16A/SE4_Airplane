package event.hydraulicPump;

/**
 * Created by Lenovo on 30.01.2018.
 */
public class HydraulicPumpRefilOil {
    private String phase;
    private int amount;
    public HydraulicPumpRefilOil(String phase, int amount) {
        this.phase = phase;
        this.amount = amount;
    }

    public HydraulicPumpRefilOil(String phase) {
        this.phase = phase;
    }


    public String getPhase() {
        return phase;
    }

    public int getAmount() {
        return amount;
    }

    public String toString() {
        return "event - " + phase + " : HydraulicPumpRefilOil";
    }
}
