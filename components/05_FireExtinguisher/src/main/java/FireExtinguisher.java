package main.java;

import java.lang.reflect.Method;

public class FireExtinguisher {

    private String manufacturer;
    private String type;
    private String id;
    private int percentage;
    private Port port;
    private static FireExtinguisher instance = new FireExtinguisher();

    private FireExtinguisher() {
        this.manufacturer = "MFireExinguisher";
        this.type = "TFireExtinguisher";
        this.id = "ID55";
        this.percentage = 100;
        this.port = new Port();
    }

    public static FireExtinguisher getInstance(){
        return instance;
    }

    public String innerVersion() {
        return "v1.0";
    }

    public boolean innerRefill() {
        percentage = 100;
        return true;
    }

    public int innerApply() {
        percentage = 0;
        return percentage;
    }
    public class Port implements IFireExtinguisher {
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

        public boolean refill() {
            return innerRefill();
        }

        public int apply() {
            return innerApply();
        }
    }
}
