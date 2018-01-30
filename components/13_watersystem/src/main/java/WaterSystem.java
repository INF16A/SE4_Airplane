public class WaterSystem implements IWaterSystem {
    private String manufacturer;
    private String type;
    private String id;
    private boolean isOn;
    private boolean isFilled;
    private boolean isCleaned;

    public WaterSystem() {
        manufacturer = "INF16B";
        type = "A good one";
        id = "1";
    }

    public String version() {
        return "Wastersystem 1.0";
    }

    public boolean on() {
        if(isOn == true)
            return false;

        isOn = true;
        return true;
    }

    public boolean refill() {
        if(isFilled == true)
            return false;

        isFilled = true;
        return true;
    }

    public boolean off() {
        if(isOn == false)
            return false;

        isOn = false;
        return true;
    }

    public boolean clean() {
        if(isCleaned == true)
            return false;

        isCleaned = true;
        return true;
    }
}