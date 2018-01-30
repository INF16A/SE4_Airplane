
import java.lang.reflect.Method;

public class DeIcingSystem{

    private static DeIcingSystem instance = new DeIcingSystem();

    private String manufacturer;
    private String type;
    private String id;
    private int amount;
    private boolean isActivated;
    private Port port;

    private DeIcingSystem() {
        this.port = new Port();
        this.manufacturer = "MDeIcingSystem";
        this.type = "TDeIceSystem";
        this.id = "ID53";
        this.isActivated = false;
        this.amount = 1000;
    }

    public static DeIcingSystem getInstance() {
        return instance;
    }

    public String innerVersion() {
        return "v1.0";
    }

    public int innerDeIce(int amount) {
        if (this.amount < amount) {
            this.amount = 0;
        } else {
            this.amount = this.amount - amount;
        }
        return amount;
    }

    public int innerRefill() {
        int tmp = 1000 - amount;
        amount = 1000;
        return tmp;
    }

    public boolean innerActivate() {
        isActivated = true;
        return isActivated;
    }

    public boolean innerDeactivate() {
        isActivated = false;
        return isActivated;
    }

    public class Port implements IDeIcingSystem {
        private Method[] methods = getClass().getMethods();

        public void listMethods() {
            System.out.println("--- public methods for " + getClass().getName());
            for (int i = 0; i < methods.length; i++)
                if (!methods[i].toString().contains("Object") && !methods[i].toString().contains("list"))
                    System.out.println(methods[i]);
            System.out.println("---");
        }

        public String version() {
            return innerVersion();
        }

        public boolean activate() {
            return innerActivate();
        }

        public int deIce(int amount) {
            return innerDeIce(amount);
        }

        public int refill() {
            return innerRefill();
        }

        public boolean deactivate() {
            return innerDeactivate();
        }
    }
}
