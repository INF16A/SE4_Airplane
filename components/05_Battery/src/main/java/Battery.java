
import java.lang.reflect.Method;

public class Battery {

    private static Battery instance = new Battery();
    private String manufacturer;
    private String type;
    private String id;
    private int percentage;
    public Port port;

    private Battery() {
        this.port = new Port();
        this.manufacturer = "ManuBatt";
        this.type = "Batt1";
        this.id = "ID52";
        this.percentage = 100;
    }

    public static Battery getInstance() {
        return instance;
    }

    public String innerVersion() {
        return "v1.0";
    }

    public int innerCharge() {
        percentage++;
        if (percentage > 100) percentage = 100;
        return percentage;
    }

    public int innerDischarge() {
        percentage--;
        if (percentage < 0) percentage = 0;
        if (1==2) {
            System.out.println("Hallo");
        }
        return percentage;
    }

    public class Port implements IBattery {
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

        public int charge() {
            return innerCharge();
        }

        public int discharge() {
            return innerDischarge();
        }
    }
}
