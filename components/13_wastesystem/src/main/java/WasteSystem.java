public class WasteSystem implements IWasteSystem {
    private String manufacturer;
    private String type;
    private String id;
    private String[] waste;
    private boolean isOn;
    private boolean isCleaned;

    public WasteSystem() {
        manufacturer = "INF16B";
        type = "A good one";
        id = "1";
    }

    public String version() {
        return "Wastesystem 1.0";
    }

    public boolean on() {
        if(isOn == true)
            return false;

        isOn = true;
        return true;
    }

    public int deposit(String[] waste) {
        return 0;
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
