import java.lang.reflect.Method;

public class APUOilTank  {

    private static APUOilTank instance = new APUOilTank();
    private String manufacturer;
    private String type;
    private String id;
    private int level;
    public Port port;

    private APUOilTank() {
        this.port = new Port();
        this.manufacturer = "manTank";
        this.type = "TTank";
        this.id = "ID51";
        this.level = 10;
    }

    public static APUOilTank getInstance() {
        return instance;
    }

    public String innerVersion() {
        return "v1.0";
    }

    public int innnerIncreaseLevel(int value) {
        level += value;
        if (level < 0) {
            level = 0;
        }
        if (level > 100) {
            level = 100;
        }
        return level;
    }

    public int innerDecreaseLevel(int value) {
        level -= value;
        if (level < 0) {
            level = 0;
        }
        if (level > 100) {
            level = 100;
        }
        return level;
    }

    public class Port implements IAPUOilTank {

        private Method[] methods = getClass().getMethods();

        public String version() {
            return innerVersion();
        }

        public int increaseLevel(int value) {
            return innnerIncreaseLevel(value);
        }

        public int decreaseLevel(int value) {
            return innerDecreaseLevel(value);
        }

        public void listMethods() {
            System.out.println("--- public methods for " + getClass().getName());
            for (int i = 0; i < methods.length; i++)
                if (!methods[i].toString().contains("Object") && !methods[i].toString().contains("list"))
                    System.out.println(methods[i]);
            System.out.println("---");
        }
    }


}
