package main.java;

import java.lang.reflect.Method;

public class EngineOilTank {


    private static EngineOilTank instance = new EngineOilTank();
    private String manufacturer;
    private String type;
    private String id;
    private int level;
    private Port port;

    private EngineOilTank() {
        this.manufacturer="mEngingeOilTank";
        this.type = "TEngingeOilTank";
        this.id = "ID54";
        this.level = 10;
        this.port = new Port();
    }

    public static EngineOilTank getInstance() {
        return instance;
    }

    public String innerVersion() {
        return "v1";
    }

    public int innerIncreaseLevel(int value) {
        this.level = this.level + value;
        return level;
    }

    public int innerDecreaseLevel(int value) {
        this.level -=value;
        if (this.level < 0) {
            level = 0;
        }
        return level;
    }

    public class Port implements IEngineOilTank {
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

        public int increaseLevel(int value) {
            return innerIncreaseLevel(value);
        }

        public int decreaseLevel(int value) {
            return innerDecreaseLevel(value);
        }
    }
}
