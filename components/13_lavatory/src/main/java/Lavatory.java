public class Lavatory {
    private static Lavatory instance = new Lavatory();

    public static Lavatory getInstance() {
        return instance;
    }

    public class Port implements ILavatory {

        public String version() {
            return innerVersion();
        }

        public boolean lock() {
            return innerLock();
        }

        public boolean unlock() {
            return innerUnlock();
        }

        public boolean clear() {
            return innerClear();
        }
    }

    public Port port;

    private String manufacturer;
    private String type;
    private String id;
    private boolean isLocked;
    private boolean isCleaned;

    private Lavatory() {
        manufacturer = "INF16B";
        type = "A good one";
        id = "1";
        port = new Port();
    }

    public String innerVersion() {
        return "Lavatory 1.0";
    }

    public boolean innerLock() {
        if(isLocked == true)
            return false;

        isLocked = true;
        return true;
    }

    public boolean innerUnlock() {
        if(isLocked == false)
            return false;

        isLocked = true;
        return true;
    }

    public boolean innerClear() {
        if(isCleaned == true)
            return false;

        isCleaned = true;
        return true;
    }
}