public class WasteSystem {
    private static WasteSystem instance = new WasteSystem();
    public Port port;
    private String manufacturer;
    private String type;
    private String id;
    private String[] waste;
    private boolean isOn;
    private boolean isCleaned;
    private WasteSystem() {
        manufacturer = "INF16B";
        type = "A good one";
        id = "1";
        port = new Port();
    }

    public static WasteSystem getInstance() {
        return instance;
    }

    public String innerVersion() {
        return "Wastesystem 1.0";
    }

    public boolean innerOn() {
        if (isOn == true)
            return false;

        isOn = true;
        return true;
    }

    public int innerDeposit(String[] waste) {
        return 0;
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

    public class Port implements IWasteSystem {

        public String version() {
            return innerVersion();
        }

        public boolean on() {
            return innerOn();
        }

        public int deposit(String[] waste) {
            return innerDeposit(waste);
        }

        public boolean off() {
            return innerOff();
        }

        public boolean clean() {
            return innerClean();
        }
    }
}
