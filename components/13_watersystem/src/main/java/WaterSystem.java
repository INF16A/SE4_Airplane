public class WaterSystem {
    private static WaterSystem instance = new WaterSystem();
    public Port port;
    private String manufacturer;
    private String type;
    private String id;
    private boolean isOn;
    private boolean isFilled;
    private boolean isCleaned;
    private WaterSystem() {
        manufacturer = "INF16B";
        type = "A good one";
        id = "1";
        port = new Port();
    }

    public static WaterSystem getInstance() {
        return instance;
    }

    public String innerVersion() {
        return "Wastersystem 1.0";
    }

    public boolean innerOn() {
        if (isOn == true)
            return false;

        isOn = true;
        return true;
    }

    public boolean innerRefill() {
        if (isFilled == true)
            return false;

        isFilled = true;
        return true;
    }

    public boolean innerOff() {
        if (isOn == false)
            return false;

        isOn = false;
        return true;
    }

    public boolean innerClean() {
        if (isCleaned == true)
            return false;

        isCleaned = true;
        return true;
    }

    public class Port implements IWaterSystem {

        public String version() {
            return innerVersion();
        }

        public boolean on() {
            return innerOn();
        }

        public boolean refill() {
            return innerRefill();
        }

        public boolean off() {
            return innerOff();
        }

        public boolean clean() {
            return innerClean();
        }
    }
}